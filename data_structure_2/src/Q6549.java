/*
히스토그램에서 가장 큰 직사각형
1. 입력을 stack 에 ( 넓이, 높이) 로 저장한다.
2. 하나를 꺼낸 후 각 넓이를 peek과 비교한다. ( pop넓이 , peek넓이, pop+peek 넓이)
--> (pop + peek 의 경우 두 요소의 높이를 비교한 후 높이가 작은 요소를 a라 할 떄 ( a의 넓이 + (a의 넓이/ a의 높이) ) 이다.)
3. 세 요소 중 가장 큰 값만 stack에 넣는다.
   3-1. peek 일 경우 그대로 다음 과정 진행
   3-2. pop 일 경우 peek 을 제거한 후 pop한 요소를 넣는다.
   3-3. pop+peek 일 경우 peek 을 제외한 후 pop+peek을 넣는다.
4. stack이 비어있다면 과정을 그만 비어있지 않다면 2로 돌아간다.
 */
public class Q6549 {
}