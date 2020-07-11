package org.gsl4j.plot.builder;

import java.util.LinkedList;
import java.util.List;

public class ArgsBuilderImpl implements Builder {

    private final String key;
    List<Object> args = new LinkedList<>();

    public ArgsBuilderImpl(String key) {
        this.key = key;
    }

    public ArgsBuilderImpl(String key, String arg) {
        this.key = key;
        addStringToArgs(arg);
    }

    public ArgsBuilderImpl(String key, String arg1, String arg2) {
        this.key = key;
        addStringToArgs(arg1);
        addStringToArgs(arg2);
    }

    public ArgsBuilderImpl(String key, Number arg) {
        this.key = key;
        addStringToArgs(arg);
    }

    public ArgsBuilderImpl(String key, Number arg1, Number arg2) {
        this.key = key;
        addStringToArgs(arg1);
        addStringToArgs(arg2);
    }

    private ArgsBuilderImpl addStringToArgs(String v) {
        // TODO: Do it with StringBuilder on join
        args.add("\"" + v + "\"");
        return this;
    }

    private ArgsBuilderImpl addStringToArgs(Number v) {
        args.add(v);
        return this;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("plt.");
        sb.append(key);
        sb.append('(');
//        Joiner.on(',').appendTo(sb, args);
        int size = args.size() ;
        for(int i=0; i<size-1; i++) {
        		sb.append(args.get(i)).append(",") ;
        }
        sb.append(args.get(size-1)) ;

        sb.append(')');

        String str = sb.toString();
        return str;
    }

    @Override
    public String getMethodName() {
        return key;
    }
}
