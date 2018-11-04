package com.tyro;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Network {

    // public Person[] network;
    public Map<Integer, Person> persons = new HashMap<Integer, Person>();
    public boolean[][] adjacency_matrix;
    public int node_count;
    public int edge_count;

    public Network(int nodeCount, Map<Integer, Person> persons, List<String> edges, List<String> totals)
            throws IOException {
        this.node_count = nodeCount;
        this.edge_count = edges.size();
        this.adjacency_matrix = new boolean[this.node_count][this.node_count];
        //////// Person[] network = new Person[node_count];
        this.persons = persons;

        for (int i = 0; i < edge_count; i++) {
            StringTokenizer st = new StringTokenizer(edges.get(i));

            int a_id = Integer.parseInt(st.nextToken());
            int b_id = Integer.parseInt(st.nextToken());

            /*
             * if (network[a_id] == null) { network[a_id] = new Person(a_id,
             * this.node_count); }
             * 
             * if (network[b_id] == null) { network[b_id] = new Person(b_id,
             * this.node_count); }
             * 
             * if (persons.containsKey(a_id)) {
             * 
             * }
             */

            this.adjacency_matrix[a_id][b_id] = true;
            this.adjacency_matrix[b_id][a_id] = true;
            // network[a_id].addFriend(b_id);
            persons.get(a_id).addFriend(b_id);
            // network[b_id].addFriend(a_id);
            persons.get(b_id).addFriend(a_id);
        }

        /// this.network = network;

        System.out.println("--------------------------");
        System.out.println(this.persons);
        System.out.println("--------------------------");

    }

    // public Network(BufferedReader br) throws IOException {
    // StringTokenizer st = new StringTokenizer(br.readLine());
    // this.node_count = Integer.parseInt(st.nextToken());
    // this.edge_count = Integer.parseInt(st.nextToken());
    // this.adjacency_matrix = new boolean[this.node_count][this.node_count];
    // Person[] network = new Person[node_count];

    // for (int i = 0; i < edge_count; i++) {
    // st = new StringTokenizer(br.readLine());
    // int a_id = Integer.parseInt(st.nextToken());
    // int b_id = Integer.parseInt(st.nextToken());

    // if (network[a_id] == null) {
    // network[a_id] = new Person(a_id, this.node_count);
    // }

    // if (network[b_id] == null) {
    // network[b_id] = new Person(b_id, this.node_count);
    // }

    // this.adjacency_matrix[a_id][b_id] = true;
    // this.adjacency_matrix[b_id][a_id] = true;
    // network[a_id].addFriend(b_id);
    // network[b_id].addFriend(a_id);
    // }

    // this.network = network;
    // }
}