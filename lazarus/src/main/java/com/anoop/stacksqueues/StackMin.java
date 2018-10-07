package com.anoop.stacksqueues;

import java.util.Stack;

import com.anoop.stacksqueues.StackMin.NodeWithMin;

/*Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
*/

/*If we kept track of the minimum at each state, we would be able to easily know the minimum. We can do
this by having each node record what the minimum beneath itself is. Then, to find the min, you just look at
what the top element thinks is the min.
When you push an element onto the stack, the element is given the current minimum. It sets its "local
min"to be the min.*/

public class StackMin extends Stack<NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }
}