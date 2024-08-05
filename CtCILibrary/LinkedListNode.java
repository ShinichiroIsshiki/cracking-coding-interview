package CtCILibrary;

public class LinkedListNode {
    // 次のノードへの参照
    public LinkedListNode next;
    // 前のノードへの参照
    public LinkedListNode prev;
    // リストの最後のノードへの参照
    public LinkedListNode last;
    // ノードが保持するデータ
    public int data;

    // コンストラクタ：データ、次のノード、前のノードを指定
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    // コンストラクタ：データのみを指定
    public LinkedListNode(int d) {
        data = d;
    }    

    // デフォルトコンストラクタ
    public LinkedListNode() { }

    // 次のノードを設定するメソッド
    public void setNext(LinkedListNode n) {
        next = n;
        // リストの最後のノードを更新
        if (this == last) {
            last = n;
        }
        // 双方向リンクを維持
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    // 前のノードを設定するメソッド
    public void setPrevious(LinkedListNode p) {
        prev = p;
        // 双方向リンクを維持
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }    

    // リストを前方向に辿って文字列として返すメソッド
    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

    // リストを再帰的にクローンするメソッド
    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        // 次のノードを再帰的にクローン
        if (next != null) {
            next2 = next.clone();
        }
        // クローンしたノードの新しいリストの先頭を作成
        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }
}
