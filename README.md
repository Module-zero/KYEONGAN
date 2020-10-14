# KYEONGAN
 - 변수 선언 작은 수가 아닐 경우 long 으로 할 것 
 - String.split(<구분자>); --> String[] 을 반환한다.
 - %(mod) 연산이 문제 조건에 있다면, answer 를 누적하는 연산을 할 때, ```answer += value%mod; ``` 가 아닌 ``` answer = (answer + value) % mod; ``` 로 해야하며, 모든 value 에 대해서 mod 연산을 해줘야 한다.
 - 알고리즘 설계시 최대 범위보다 크고, 최소 범위보다 작은 경우의 예외처리를 생각해야 한다.
