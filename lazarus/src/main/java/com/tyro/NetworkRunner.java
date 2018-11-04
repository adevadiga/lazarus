package com.tyro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class NetworkRunner {
    public static void main(String[] args) throws Exception {
        int node_count = 4;
        int edge_count = 2; // Friendship edge count or noOfConnection

        List<String> queryType = new ArrayList<String>();

        queryType.add("Friend 1 2");
        queryType.add("Friend 2 3");
        queryType.add("Total  1 4");

        List<Integer> students1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        getTheGroups(4, queryType, students1, new ArrayList<Integer>());

    }

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1,
            List<Integer> students2) throws Exception {

        int node_count = n;
        List<String> edges = new ArrayList<String>();
        List<String> totals = new ArrayList<String>();

        for (String line : queryType) {
            /*if (line.indexOf("Friend") > -1) {// Its an edge in graph
                edges.add(line.replace("Friend ", ""));
            } else if (line.indexOf("Total") > -1) {
                totals.add(line.replace("Total ", ""));
            }*/
            edges
        }

        // Person[] persons = new Person[node_count];
        Map<Integer, Person> persons = new HashMap<Integer, Person>();
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (Integer s1 : students1) {
            persons.put(s1, new Person(s1, node_count));
        }

        for (Integer s1 : students2) {
            persons.put(s1, new Person(s1, node_count));
        }

        Network network = new Network(n, persons, edges, totals);
        Map<Integer, Person> net = network.persons;

        for (Map.Entry<Integer, Person> entry : net.entrySet()) {
            entry.getValue().countMutuals2(network);

            Integer studentId = entry.getValue().id;
            Integer friendCount = entry.getValue().friend_count;
            int num_of_mutuals = entry.getValue().num_of_mutuals;
            System.out.println(studentId + " -> " + (friendCount + num_of_mutuals + 1));
            resultMap.put(studentId, (friendCount + num_of_mutuals + 1));
        }

        int k = 0;
        for (String query : totals) {
            StringTokenizer st = new StringTokenizer(query);
            while (st.hasMoreElements()) {
                int sid = Integer.parseInt(st.nextToken());
                if (resultMap.containsKey(sid)) {
                    // resultMap.get(sid);
                    result.add(resultMap.get(sid));
                }
            }
        }

        System.out.println("#######");
        System.out.println(result);
        return null;
    }
}
