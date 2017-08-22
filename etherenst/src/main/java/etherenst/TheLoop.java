package etherenst;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import etherenst.debg.Debug;

public class TheLoop implements Runnable {

	public static long TICK_RATE = 1000 / 30;

	private EtherenST os;

	Debug debug;

	ScheduledFuture<?> service;

	ArrayList<Job> scheduled = new ArrayList<Job>(32);

	TheLoop(EtherenST os) {
		this.os = os;

		// begin the loop
		service = Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this::run, 0, TICK_RATE,
				TimeUnit.MILLISECONDS);
	}

	@Override
	public void run() {
		try {
			if (debug != null) {
				debug.update();
			}

			if (scheduled.size() > 0)
				scheduled.parallelStream().forEach(job -> {
					if (job.ticksLeft-- == 0) {
						job.r.run();
						scheduled.remove(job);
					}
				});

			for (Realm realm : os.realms()) {
				realm.update();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public void stop() {
		service.cancel(false);
	}

	public class Job {
		int ticksLeft;
		Runnable r;

		public Job(int ticks, Runnable r) {
			this.ticksLeft = ticks;
			this.r = r;
		}
	}

}
