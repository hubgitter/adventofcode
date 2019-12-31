package main.java.domain;

import java.util.*;
import java.util.stream.Collectors;

public class OrbitCalculator {

    private List<Orbit> orbits;
    private Set<String> orbitIds = new HashSet<>();
    public OrbitCalculator(List<Orbit> orbits){
        this.orbits = orbits;
        orbits.stream().forEach(o->{
            orbitIds.add(o.subOrbitId());
            orbitIds.add(o.superOrbitId());
            });
    }
    public int calculateSumOfAllOrbits(){
      return orbitIds.stream().map(i-> calculateRecursiveAudits(i)).collect(Collectors.summingInt(Integer::intValue));
    }

    public int calculateMinDistance(String from, String to){
        String fromOrbit = orbits.stream().filter(o->o.superOrbitId().equals(from)).findFirst().map(o->o.subOrbitId()).orElse(null);
        String toOrbit = orbits.stream().filter(o->o.superOrbitId().equals(to)).findFirst().map(o->o.subOrbitId()).orElse(null);
        Map<String,Integer> childDistancesFrom = new HashMap<>();
        Map<String, Integer> childDistancesTo = new HashMap<>();
        getChildDistances(childDistancesFrom, fromOrbit);
        getChildDistances(childDistancesTo, toOrbit);
        Map<String, Integer> totalCommonDistances = new HashMap<>();
        Set<String> keyset = childDistancesFrom.keySet();
        keyset.retainAll(childDistancesTo.keySet());
        keyset.stream().forEach(k->totalCommonDistances.put(k,childDistancesFrom.get(k)+childDistancesTo.get(k)));
        return totalCommonDistances.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .findFirst()
                .map(Map.Entry::getValue).orElse(0);
    }

    private int calculateRecursiveAudits(String orbitId){
        //recursively add 1 for each sub-orbit
        return orbits.stream().filter(orbit->orbit.superOrbitId().equals(orbitId))
                .map(orbit-> orbit.subOrbitId()).findAny().map(
                    subOrbit-> calculateRecursiveAudits(subOrbit)+1).orElse(0);
    }

    private  void getChildDistances(Map<String, Integer> distances, String orbitId) {
        String subOrbit = orbits.stream().filter(orbit -> orbit.superOrbitId().equals(orbitId))
                .map(orbit -> orbit.subOrbitId()).findAny().orElse(null);

        if (subOrbit == null) {
            return;
        }
        distances.put(subOrbit, distances.size()+1);
        getChildDistances(distances, subOrbit);
    }
}



