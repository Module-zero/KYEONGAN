# KYEONGAN
### 2020.10.05 ~   
 - 변수 선언 작은 수가 아닐 경우 long 으로 할 것 
 - String.split(<구분자>); --> String[] 을 반환한다.
 - %(mod) 연산이 문제 조건에 있다면, answer 를 누적하는 연산을 할 때, ```answer += value%mod; ``` 가 아닌 ``` answer = (answer + value) % mod; ``` 로 해야하며, 모든 value 에 대해서 mod 연산을 해줘야 한다.
 - 알고리즘 설계시 최대 범위보다 크고, 최소 범위보다 작은 경우의 예외처리를 생각해야 한다.
 - **중복된 값을 제거** 하기 위해서는 ```Hash 계열``` 의 자료구조를 사용하면 편리하다.
 - ```Arrays.sort(Array,startIdx,endIdx);``` 를 사용할 경우 ```startIdx``` 는 정렬 범위에 포함되나 ```endIdx``` 는 포함되지 않는다.  
 	따라서 ```endIdx``` 는 1 큰수를 넣어줘야 한다.
 - ```ArrayList<Integer>[]``` 는 **ArrayList<Integer>** 를 담는 배열 타입이다. 즉, ```ArrayList<Integer>[0] = new ArrayList<Integer>``` 처럼 사용하며 대표적으로 **그래프** 관련 알고리즘을 풀때 사용한다.
 - ```ArrayList``` 와 같은 컬랙션 타입의 정렬은 ```Arrays.sort()``` 가 아닌 ```Collections.sort()``` 를 사용할 수 있다. 
