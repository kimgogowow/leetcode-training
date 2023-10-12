202 happy number[number digit sum,two pointer, linkedlist]
class Solution {
        public boolean isHappy(int n) {
                //数学验证如果是unhappy num，sum会在某个点进入循环，因此可以用linkedlist的思路做。
                int slow = n;
                int fast = n;
                do{
                        slow = calSum(slow);
                        fast = calSum(calSum(fast));
                }while(slow != fast);
//这里用do-while是因为一开始slow和fast是一样的，这个loop就不会跑了。
                return slow ==1;
        }

        public int calSum(int n){
                int sum = 0;
                while(n>0){
                        //一直拿到最后一位
                        int reminder = n%10;
                        sum += reminder*reminder;
                        n /=10;
                }
                return sum;

        }

}