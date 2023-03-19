package logic;

public class NotWff extends Wff {
    private Wff wff;
    private final Operator op = Operator.NOT;

    public NotWff(Wff wff) {
        this.wff = wff;
    }

    @Override
    public boolean eval(Valuation val) {
        return !wff.eval(val);
    }

    @Override
    public String toString() {
        return String.format("%s%s", op, wff);
    }
}
