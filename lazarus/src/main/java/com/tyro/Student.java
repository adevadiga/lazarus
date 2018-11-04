class Result {

    /*
     * Complete the 'getTheGroups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER n 2. STRING_ARRAY queryType 3. INTEGER_ARRAY
     * students1 4. INTEGER_ARRAY students2
     */

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1,
            List<Integer> students2) {
        int node_count = n;
        List<String> edges = new ArrayList<String>();
        List<String> totals = new ArrayList<String>();

        
        //Process input of format 
        //Friend 1 2
        //Friend 2 3
        //Total  1 4
        /*String message = queryType + ", " + students1 + ",  " + students2;
        boolean val = true;
        if (val) {
            throw new RuntimeException(message);
        }*/

        for (String line : queryType) {
            if (line.indexOf("Friend") > -1) {// Its an edge in graph
                edges.add(line.replace("Friend ", ""));
            } else if (line.indexOf("Total") > -1) {
                totals.add(line.replace("Total ", ""));
            }
        }

        Map<Integer, Student> students = new HashMap<Integer, Student>();
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (Integer s1 : students1) {
            students.put(s1, new Student(s1, node_count));
        }

        for (Integer s2 : students2) {
            students.put(s2, new Student(s2, node_count));
        }

        Network network = new Network(n, students, edges, totals);
        Map<Integer, Student> studentsMap = network.students;

        for (Map.Entry<Integer, Student> entry : studentsMap.entrySet()) {
            entry.getValue().countMutuals2(network);

            int studentId = entry.getValue().id;
            int friendCount = entry.getValue().friendCount;
            int numOfMutuals = entry.getValue().numOfMutuals;
            resultMap.put(studentId, (friendCount + numOfMutuals + 1));
        }

        int k = 0;
        for (String query : totals) {
            StringTokenizer st = new StringTokenizer(query);
            while (st.hasMoreElements()) {
                int sid = Integer.parseInt(st.nextToken());
                if (resultMap.containsKey(sid)) {
                    result.add(resultMap.get(sid));
                }
            }
        }

        return result;
    }
}

class Student {

    public int id;
    public int[] friendsList;
    public int friendCount;
    public int numOfMutuals;

    public Student(int id, int network_size) {
        this.id = id;
        this.friendsList = new int[network_size];
    }

    public int countMutuals2(Network n) {
        this.numOfMutuals = 0; 
        Map<Integer, Student> network = n.students;
        boolean[][] adjacency_matrix = n.adjacency_matrix;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < this.friendCount; i++) {
            q.add(this.friendsList[i]);
        }

        while (!q.isEmpty()) {
            Student current = network.get(q.poll());
            for (int i = 0; i < current.friendCount; i++) {
                if (current.friendsList[i] != this.id && !adjacency_matrix[this.id][current.friendsList[i]]) {
                    this.numOfMutuals++;
                }
            }
        }
        return numOfMutuals;
    }

    public void addFriend(int id) {
        this.friendsList[this.friendCount++] = id;
    }

    public String toString() {
        return this.id + " has " + this.friendCount + " friends.";
    }
}

class Network {

    public Map<Integer, Student> students = new HashMap<Integer, Student>();
    public boolean[][] adjacency_matrix;
    public int node_count;
    public int edge_count;

    public Network(int nodeCount, Map<Integer, Student> students, List<String> edges, List<String> totals) {
        this.node_count = nodeCount;
        this.edge_count = edges.size();
        this.adjacency_matrix = new boolean[this.node_count][this.node_count];
        this.students = students;

        for (int i = 0; i < edge_count; i++) {
            StringTokenizer st = new StringTokenizer(edges.get(i));

            int a_id = Integer.parseInt(st.nextToken());
            int b_id = Integer.parseInt(st.nextToken());

            this.adjacency_matrix[a_id][b_id] = true;
            this.adjacency_matrix[b_id][a_id] = true;
            students.get(a_id).addFriend(b_id);
            students.get(b_id).addFriend(a_id);
        }
        System.out.println(this.students);
    }
}
