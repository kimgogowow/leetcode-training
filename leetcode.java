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

2457. Minimum Addition to Make Integer Beautiful [math,number sum]
class Solution {
        public long makeIntegerBeautiful(long n, int target) {
                long n0 = n, base = 1;//n=123,t=3
                while(calSum(n)>target){//sum= 6 >3
                        n = n/10 +1; //n=12+1 = 13
                        base *= 10; //base = 1*10 = 10
                }
                return base * n - n0; //10*13 -123 = 130-123 = 7


        }
        public long calSum(long n){
                long sum = 0;
                while(n>0){
                        sum += n%10;
                        n /= 10;
                }
                return sum;
        }
}