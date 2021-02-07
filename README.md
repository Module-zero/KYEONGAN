# KYEONGAN__
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
 - 트리의 지름을 구하는 방법은 임의의 정점에서 가장 먼 정점을 구한 후 구해진 정점에서 가장 먼 정점까지의 거리가 트리의 지름이다.
 - ```Collections.sort()``` 를 사용할 시 **두번째 인자로 정렬 기준** 을 지정할 수 있다. 여러 방법이 있지만, 익명함수를 사용하면 더욱 간단다하다.  
ex) ```Collections.sort(list,(a,b) -> order[b] - order[a] ) ;```  
--> ```order``` 이라는 배열에 정렬 기준을 놓고 그 기준에 맞춰 정렬.
- UpperBound : 상한의 최저/ LowerBound : 하한의 최고  
	( Tree의 ceilingEntry() 를 통해 얻을 수 있다.)

- 실수의 값은 ```==``` 로 비교할 수 없다. 따라서 **이분탐색** 을 할 경우 ```while(left <= right)``` 와 같은 코드가 아닌 ```for문``` 을 통해 이분탐색을 해야한다. ```for문``` 의 최대 반복 횟수는 **오차 허용 범위 * 0.1 의 역수까지** 이다.  
Ex) 오차범위가 10^-3 일 경우 **10^-3 * 10^-1 = 10^-4 의 역수는 10000 ** 로 한다!!
- 가중치가 있는 단방향 그래프는 편도로 왔다갔다 보다 반대 방향의 그래프를 하나 더 만들어서 그래프를 총 2개를 이용해서  왔다갔다 거리를 측정하는게 훨 속도가 빠르다.  

## union find ( 상호 배타적 조합 )
이 알고리즘은 원소 a 와 b사이의 관계에 대해 알아보고자 할 때 사용한다.  
즉, a가 있는 집단에 b가 있는지, b가 있는 집단에 a가 있는지 를 알아보기 위해 사용한다. 
a 와 b의 관계를 알아보기 위해 사용하는 ```find()``` 함수는 다음과 같다.
```
int find(a){
	if(a == parent[a])
		return a;
	else
		return parent[a] = find(parent[a]); // 경로 압축
}
```
- a와 b의 집합을 합칠 때 사용하는 ```union()``` 다음과 같다. (-> 각 집합의 weight(rank)를 유의하여 합쳐야 한다)
```
void union(int a, int b){
	a = find(a);
	b = find(b);
	if(a == b) // 두 수의 부모가 같다면 
		return ; // 함수 종료
		
	// 두 수의 weight (rank)를 비교한다.
	if(rank[a] > rank[b]){  
		parent[b] = a; 		// rank 가 작은 집합의 부모에 다른 수를 집어넣는다. 
		rank[a] += rank[b];	// 랭크도 같이 ! ( 랭크는 랭크가 큰 집합의 부모에 작은 집합의 부모의 랭크를 더한다)
	}
	else{
		parent[a] = b;
		rank[b] += rank[a];	
	}
}
```
