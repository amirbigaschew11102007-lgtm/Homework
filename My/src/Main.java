//import java.util.*;
//import java.util.stream.Collectors;
//
//class Edge {
//    String target;
//    int weight;
//
//    Edge(String target, int weight) {
//        this.target = target;
//        this.weight = weight;
//    }
//    Edge(String target) {
//        this.target = target;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        return Objects.equals(target, ((Edge) o).target);
//    }
//    public String getTarget() {
//        return target;
//    }
//
//    public void setTarget(String target) {
//        this.target = target;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//}
//
//
//public class Main {
//    public static void main(String[] args) {
//        Map<Edge, List<Edge>> graph = new HashMap<>();
//
//        graph.put(new Edge("A"), List.of(new Edge("B", 3), new Edge("C", 1)));
//        graph.put(new Edge("B"), List.of(new Edge("E", 6)));
//        graph.put(new Edge("C"), List.of(new Edge("D", 2), new Edge("F", 9)));
//        graph.put(new Edge("D"), List.of(new Edge("E", 3)));
//        graph.put(new Edge("E"), List.of(new Edge("G", 4)));
//        graph.put(new Edge("F"),List.of(new Edge("E",12)));
//        graph.put(new Edge("G"),null);
//
//        Integer[] minSize= new Integer[graph.size()];
//        Set<Edge> edge = new HashSet<>();
//
//        minSize[0]=0;
//        for (int i=1;i< graph.size();i++){
//            minSize[i]=1_000_000_000;
//        }
//        List<Edge> keyList = new ArrayList<>(graph.keySet());
//
//        while (edge.size()!=graph.size()){
//            Edge edge1 =null;
//            int minSizeOnEdge=10000000;
//
//            for (int i=0;i<minSize.length;i++){
//                if (!edge.contains(keyList.get(i)) && (minSize[i] < minSizeOnEdge)){
//                    minSizeOnEdge=minSize[i];
//                    edge1=keyList.get(i);
//                }
//            }
//
//            if (edge1==null){
//                break;
//            }
//
//            edge.add(edge1);
//            graph.values().stream().map(Map.Entry.<Edge,List<Edge>>comparingByValue());
//        }
//    }
//}

import java.util.*;

class Edge {
    private String target;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


    Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    Edge(String target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(target, ((Edge) o).target);
    }

    // Добавлен hashCode, необходим для корректной работы с Set/Map
    @Override
    public int hashCode() {
        return Objects.hash(target);
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Edge, List<Edge>> graph = new HashMap<>();

        graph.put(new Edge("A"), List.of(new Edge("B", 3), new Edge("C", 1)));
        graph.put(new Edge("B"), List.of(new Edge("E", 6)));
        graph.put(new Edge("C"), List.of(new Edge("D", 2), new Edge("F", 9)));
        graph.put(new Edge("D"), List.of(new Edge("E", 3)));
        graph.put(new Edge("E"), List.of(new Edge("G", 4)));
        graph.put(new Edge("F"), List.of(new Edge("E", 12)));
        graph.put(new Edge("G"), new ArrayList<>());

        Set<Edge> edge = new HashSet<>();//уже использованные вершины
        List<Edge> keyList = new ArrayList<>(graph.keySet());//лист ключей (первое значение)

        Integer[] minSize = new Integer[graph.size()];//минимальный вес для алгоритма деикстрея

        Arrays.fill(minSize, 1_000_000_000);
        minSize[0] = 0; // Предполагаем, что A (первый элемент) - стартовая

        while (edge.size() != graph.size()) {
            Edge edge1 = null;
            int minSizeOnEdge = 1_000_000_000;
            int u = -1;//самая близкая вершина

            //смотрим на ближайший город и едем к нему(запоминаем только значение)
            for (int i = 0; i < keyList.size(); i++) {
                if (!edge.contains(keyList.get(i)) && (minSize[i] < minSizeOnEdge)) {
                    minSizeOnEdge = minSize[i];
                    edge1 = keyList.get(i);
                    u = i;
                }
            }
            //сразу если нет такого города(вершины) брейкаем
            if (edge1 == null) {
                break;
            }
            // добавляем в посещённые города(вершины)
            edge.add(edge1);

            // Релаксация (обновление путей)
            List<Edge> neighbors = graph.get(edge1);//список соседей(смежных вершин) .get(edge1) оказывается выдаёт наше value
            if (neighbors != null) {
                for (Edge neighbor : neighbors) {
                    for (int i = 0; i < keyList.size(); i++) {
                        if (keyList.get(i).getTarget().equals(neighbor.getTarget())//проверяем по названию
                                && minSize[u] + neighbor.getWeight() < minSize[i]) {
                            minSize[i] = minSize[u] + neighbor.getWeight();
                        }
                    }
                }
            }
        }
        for (int i = 0; i < keyList.size(); i++) {
            System.out.println(keyList.get(i).getTarget() +" : "+ minSize[i]);
        }
    }
}