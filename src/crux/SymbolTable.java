package crux.frontend;

import crux.frontend.ast.Position;
import crux.frontend.types.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class SymbolTable {
    private final PrintStream err;
    private final List<Map<String, Symbol>> symbolScopes = new ArrayList<>();

    private boolean encounteredError = false;

    SymbolTable(PrintStream err) {
        System.out.println("111111");
        this.err = err;
        // TODO
    }

    boolean hasEncounteredError() {
        return encounteredError;
    }

    void enter() {
        System.out.println("222222");
        Map< String,Symbol> newS = new HashMap< String,Symbol>();
        symbolScopes.add(newS);
        // TODO
        
    }

    void exit() {
        System.out.println("3333333");
        symbolScopes.remove(symbolScopes.size()-1);
        // TODO
    }

    Symbol add(Position pos, String name) {
        System.out.println("4444444");
        System.out.println(name);
        // TODO
        Symbol sy = new Symbol(name);

//        if (symbolScopes.get(symbolScopes.size() - 1).containsKey(name)) {
//            err.printf("ResolveSymbolError%s[Could not find %s.]%n", pos, name);
//            encounteredError = true;
//            return new Symbol(name, "ResolveSymbolError");
//        }
        if (symbolScopes.get(symbolScopes.size() - 1).containsKey(name)){
            System.out.println("already IN");
        }
        symbolScopes.get(symbolScopes.size() - 1).put(name,sy);
        System.out.println(symbolScopes.toString());
        return sy;
    }

    Symbol add(Position pos, String name, Type type) {
        System.out.println("5555555555555");
        System.out.println(name);
        // TODO
        Symbol sy = new Symbol(name,type);
        Map m = new HashMap<String,Symbol>();
        m.put(name, sy);
        symbolScopes.add(m);
        return sy;
    }

    Symbol lookup(Position pos, String name) {
        System.out.println("666666");
        System.out.println(name);
        var symbol = find(name);
        if (symbol == null) {
            err.printf("ResolveSymbolError%s[Could not find %s.]%n", pos, name);
            encounteredError = true;
            return new Symbol(name, "ResolveSymbolError");
        } else {
            return symbol;
        }
    }

    private Symbol find(String name) {
        System.out.println(7777777);
        // TODO
        for(var i=0; i<this.symbolScopes.size();i++){
            if (symbolScopes.get(i).containsKey(name)){
                return symbolScopes.get(i).get(name);
            }
        }
        return null;
    }
}
