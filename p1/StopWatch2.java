public class StopWatch {

    private State state = State.IDLE;

    // Define enum for state
    private enum State {
        IDLE, RUNNING, SUSPENDED
    }

    public boolean start() {
        if (state != State.IDLE) {
            return false;
        }

        // logic
        state = State.RUNNING;
        return true;
    }

    public boolean stop() {
        if (state != State.RUNNING && state != State.SUSPENDED) {
            return false;
        }

        // logic
        state = State.IDLE;
        return true;
    }

    public boolean pause() {
        if (state != State.RUNNING) {
            return false;
        }

        // logic
        state = State.SUSPENDED;
        return true;
    }

    public boolean resume() {
        if (state != State.SUSPENDED) {
            return false;
        }

        // logic
        state = State.RUNNING;
        return true;
    }
}
