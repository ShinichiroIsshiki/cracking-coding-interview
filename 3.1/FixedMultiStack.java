import java.util.EmptyStackException;

import CtCILibrary.AssortedMethods;

public class FixedMultiStack {
    // 三つのスタックを管理するための基本的なパラメータ
    private int numberOfStacks = 3; // スタックの数（3つのスタック）
    private int stackCapacity; // 各スタックの容量
    private int[] values; // すべてのスタックの値を格納する配列
    private int[] sizes; // 各スタックの現在のサイズを追跡する配列
    
    // コンストラクタ：スタックサイズを受け取り、各スタックの容量を設定
    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks]; // 配列のサイズを全体のスタック容量に基づいて決定
        sizes = new int[numberOfStacks]; // 各スタックのサイズを初期化（すべて0）
    }

    /* 指定されたスタックに値をプッシュするメソッド */
    public void push(int stackNum, int value) throws FullStackException {
        /* スタックが満杯でないかを確認 */
        if (isFull(stackNum)) { 
            throw new FullStackException(); // 満杯の場合、例外をスロー
        }
        
        /* スタックのポインタをインクリメントし、値を追加 */
        sizes[stackNum]++; // 指定されたスタックのサイズを増やす
        values[indexOfTop(stackNum)] = value; // 配列の適切な位置に値を挿入
    }

    /* 指定されたスタックから値をポップするメソッド */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException(); // スタックが空の場合、例外をスロー
        }
        
        int topIndex = indexOfTop(stackNum); // 現在のトップのインデックスを取得
        int value = values[topIndex]; // トップの値を取得
        values[topIndex] = 0; // トップの位置をクリア（0を代入）
        sizes[stackNum]--; // スタックのサイズをデクリメント
        return value; // ポップされた値を返す
    }

    /* 指定されたスタックのトップを覗くメソッド（値を取り出さない） */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException(); // スタックが空の場合、例外をスロー
        }        
        return values[indexOfTop(stackNum)]; // トップの値を返す
    }

    /* スタックが空であるかを判定するメソッド */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0; // サイズが0なら空と判定
    }
    
    /* スタックが満杯であるかを判定するメソッド */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity; // サイズが最大容量と等しければ満杯
    }
    
    /* 指定されたスタックのトップのインデックスを計算するメソッド */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity; // スタックごとの開始位置を計算
        int size = sizes[stackNum]; // 現在のスタックのサイズを取得
        return offset + size - 1; // トップのインデックスを返す
    }    
    
    /* 配列全体の値を取得するメソッド */
    public int[] getValues() {
        return values;
    }
    
    /* 指定されたスタックの現在の値を配列として取得するメソッド */
    public int[] getStackValues(int stackNum) {
        int[] items = new int[sizes[stackNum]]; // スタックのサイズ分の配列を作成
        for (int i = 0; i < items.length; i++) {
            items[i] = values[stackNum * stackCapacity + i]; // 各スタックの値をコピー
        }
        return items;
    }
    
    /* スタックの内容を文字列として返すメソッド */
    public String stackToString(int stackNum) {
        int[] items = getStackValues(stackNum); // スタックの値を取得
        return stackNum + ": " + AssortedMethods.arrayToString(items); // スタック番号とその内容を返す
    }    
}
