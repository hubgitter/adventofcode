package main.java.domain;

public class Orbit {
    public Orbit(String pair){
        String parts[] = pair.split("\\)");
        subOrbit = parts[0];
        superOrbit = parts[1];
    }
    private String subOrbit;
    private String superOrbit;

    @Override
    public String toString(){
        return String.format("o1:%s,o2:%s", subOrbit, superOrbit);
    }

    public String subOrbitId() {
        return subOrbit;
    }

    public String superOrbitId() {
        return superOrbit;
    }

}
