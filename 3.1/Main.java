public class Main {
    public static void main(String[] args) {
        // スタックの各スタックサイズを5に設定して、FixedMultiStackを初期化
        FixedMultiStack stacks = new FixedMultiStack(5);
        
        try {
            // スタック0に値をプッシュ
            stacks.push(0, 10);
            stacks.push(0, 20);
            stacks.push(0, 30);

            // スタック1に値をプッシュ
            stacks.push(1, 40);
            stacks.push(1, 50);

            // スタック2に値をプッシュ
            stacks.push(2, 60);

            // 各スタックのトップの値を確認
            System.out.println("スタック0のトップの値: " + stacks.peek(0)); // 出力: 30
            System.out.println("スタック1のトップの値: " + stacks.peek(1)); // 出力: 50
            System.out.println("スタック2のトップの値: " + stacks.peek(2)); // 出力: 60

            // 各スタックからポップして値を取得
            System.out.println("スタック0からポップ: " + stacks.pop(0)); // 出力: 30
            System.out.println("スタック1からポップ: " + stacks.pop(1)); // 出力: 50
            System.out.println("スタック2からポップ: " + stacks.pop(2)); // 出力: 60

            // 再度各スタックのトップの値を確認
            System.out.println("スタック0のトップの値: " + stacks.peek(0)); // 出力: 20
            System.out.println("スタック1のトップの値: " + stacks.peek(1)); // 出力: 40

            // スタックの状態を文字列で出力
            System.out.println("スタック0の内容: " + stacks.stackToString(0)); // 出力: 0: 20, 10
            System.out.println("スタック1の内容: " + stacks.stackToString(1)); // 出力: 1: 40
            System.out.println("スタック2の内容: " + stacks.stackToString(2)); // 出力: 2: (空)

            // スタック0が空になるまでポップ
            System.out.println("スタック0からポップ: " + stacks.pop(0)); // 出力: 20
            System.out.println("スタック0からポップ: " + stacks.pop(0)); // 出力: 10

            // スタック0が空か確認
            System.out.println("スタック0は空ですか？ " + stacks.isEmpty(0)); // 出力: true

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
