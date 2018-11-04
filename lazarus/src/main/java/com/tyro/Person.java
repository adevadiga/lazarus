package com.tyro;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Person {

    public int id;
    public int[] friends_list;
    public int friend_count;
    public int num_of_mutuals;

    public Person(int id, int network_size) {
        this.id = id;
        this.friends_list = new int[network_size];
    }

    public int countMutuals2(Network n) {
        this.num_of_mutuals = 0; // Make it 1 as he is friend of himself
        // Person[] network = n.network;
        Map<Integer, Person> network = n.persons;
        boolean[][] adjacency_matrix = n.adjacency_matrix;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < this.friend_count; i++) {
            q.add(this.friends_list[i]);
        }

        while (!q.isEmpty()) {
            // Person current = network[q.poll()];
            Person current = network.get(q.poll());
            for (int i = 0; i < current.friend_count; i++) {
                if (current.friends_list[i] != this.id && !adjacency_matrix[this.id][current.friends_list[i]]) {
                    this.num_of_mutuals++;
                    /*
                     * if (!mutual_count.containsKey(current.friends_list[i])) {
                     * mutual_count.put(current.friends_list[i], 1); this.num_of_mutuals++; } else {
                     * mutual_count.replace(current.friends_list[i],
                     * mutual_count.get(current.friends_list[i]) + 1); }
                     */
                }
            }
        }

        System.out.println("num_of_mutuals => " + this.num_of_mutuals);
        return num_of_mutuals;
    }

    public TreeMap<Integer, Integer> countMutuals(Network n) {
        this.num_of_mutuals = 0; // Make it 1 as he is friend of himself
        // Person[] network = n.network;
        Map<Integer, Person> network = n.persons;
        boolean[][] adjacency_matrix = n.adjacency_matrix;

        Queue<Integer> q = new LinkedList<Integer>();
        TreeMap<Integer, Integer> mutual_count = new TreeMap<Integer, Integer>();

        for (int i = 0; i < this.friend_count; i++) {
            q.add(this.friends_list[i]);
        }

        while (!q.isEmpty()) {
            // Person current = network[q.poll()];
            Person current = network.get(q.poll());
            for (int i = 0; i < current.friend_count; i++) {
                if (current.friends_list[i] != this.id && !adjacency_matrix[this.id][current.friends_list[i]]) {
                    if (!mutual_count.containsKey(current.friends_list[i])) {
                        mutual_count.put(current.friends_list[i], 1);
                        this.num_of_mutuals++;
                    } else {
                        mutual_count.replace(current.friends_list[i], mutual_count.get(current.friends_list[i]) + 1);
                    }
                }
            }
        }

        System.out.println("num_of_mutuals => " + this.num_of_mutuals);
        return mutual_count;
    }

    public void addFriend(int id) {
        this.friends_list[this.friend_count++] = id;
    }

    public String toString() {
        return this.id + " has " + this.friend_count + " friends.";
    }
}