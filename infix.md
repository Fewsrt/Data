            String op = ops.pop();
            double v = qvals.pop();
        if (op.equals("+"))    v = qvals.add(e) + v;
            else if (op.equals("-"))    v = qvals.add() - v;
            else if (op.equals("*"))    v = qvals.pop() * v;
            else if (op.equals("/"))    v = qvals.pop() / v;
            else if (op.equals("sqrt")) v = Math.sqrt(v);
            else if(op.equals("^")) v=Math.pow(qvals.pop(),v);
            qvals.push(v);