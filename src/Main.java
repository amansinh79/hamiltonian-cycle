import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static Node[][] board;
    public static int width,height;
    public static ArrayList<Node> path;

    public static HashSet<Node> visited;
    public static Node start;

    private static final int frameWidthAndHeight = 800;

    //size of node in grid
    public static int rectSize = 40;

    static JFrame f;
    static Canvas canvas;

    static ArrayList<Node> startChildren;
    public static void main(String[] args) {
        board = new Node[6][6];
        path = new ArrayList<>();
        visited = new HashSet<>();
        height = board.length;
        width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Node(i, j);
            }
        }
        start = board[0][0];
        startChildren = getChildren(start);
        visited.add(start);
        path.add(start);
        System.out.println(hamiltonianCycle(start));
//        System.out.println(path);
        f = new JFrame();
        f.setSize(frameWidthAndHeight,frameWidthAndHeight);
        canvas = new Canvas();
        f.add(canvas);
        f.getContentPane().setBackground(Color.BLACK);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Hamiltonian Cycle");
        f.setVisible(true);



    }

    public static boolean hamiltonianCycle(Node n){
        if(path.size() == height*width) {
            if(startChildren.contains(n)){
                return true;
            }
        }
        var children = getChildren(n);
//        Collections.shuffle(children);
        for(var c : children){
            if(!visited.contains(c)){
                visited.add(c);
                path.add(c);
                if(hamiltonianCycle(c)){
                    return true;
                }
                visited.remove(c);
                path.remove(c);
            }
        }
        return false;
    }

    public static ArrayList<Node> getChildren(Node current) {

        ArrayList<Node> ans = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((j == 0 && i == 0)|| (i == -1 && j == -1) || (i == -1 && j == 1) || (i == 1 && j == -1) || (i == 1 && j == 1))
                    continue;
                int dx = current.getX() + i;
                int dy = current.getY() + j;

                if (dx < 0 || dy < 0 || dx > height - 1 || dy > width - 1)
                    continue;
                ans.add(board[dx][dy]);
            }
        }
        return ans;
    }
}


