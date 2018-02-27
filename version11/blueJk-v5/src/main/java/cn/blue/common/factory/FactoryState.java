package cn.blue.common.factory;

public enum FactoryState {
    FACTORY_STATE_START("1"), FACTORY_STATE_STOP("0");
    private String state;

    FactoryState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
