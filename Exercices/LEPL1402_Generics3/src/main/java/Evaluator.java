import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (s1,s2)-> {
          return (s1 && !s2) || (!s1 && s2);
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (s1,s2) -> {
          return (s1 || s2);
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (s1,s2)-> {
          return (s1 && s2);
        };
    }

    public Function<Boolean, Boolean> not_gate() {
        return (s1) -> {
          return !s1;
        };
    }

    // Should return a map with the results stored in map ( use HashMap )
    // Keys are "SUM", "CarryOut"
    // TODO WARNING : USE HERE ONLY the previously defined method to compute result (as inginious will prevent you to cheat to directly invoke logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        HashMap<String, Boolean> toReturn = new HashMap<>(2);
        Boolean sum;
        Boolean carryOut;
        sum = xor_gate().apply(xor_gate().apply(a, b), carry_in);
        carryOut = or_gate().apply(and_gate().apply(carry_in,xor_gate().apply(a,b)),and_gate().apply(a,b));
        toReturn.put("SUM", sum);
        toReturn.put("CarryOut", carryOut);
        return toReturn;
    }

}