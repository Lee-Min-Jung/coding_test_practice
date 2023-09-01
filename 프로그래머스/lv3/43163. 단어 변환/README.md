# [level 3] 단어 변환 - 43163 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43163) 

### 회고
<ul>
<li>어떻게 접근해야 하는지 고민을 많이 했다. 만약 dfs/bfs 테마에 없었으면 아예 감을 못 잡고 구현인가.. 이랬을듯</li>
<li>근데 핵심은 words를 탐색해야한다는 것. 그래서 완전탐색이든 그냥 기본적인 dfs나 bfs를 사용해야 하는데 예전에 계속 했던 dfs를 활용한 순열 완전탐색이 적합한 듯 했다. 다른 풀이를 참고하니.</li>
<li>그런데 완전탐색 해 나가면서 탐색 횟수가 가장 작은 걸 리턴해야하는데 왜 그걸 처리 안 했는데도 통과가 된거지..? 이해가 안 감</li>
</ul>


### 성능 요약

메모리: 76.7 MB, 시간: 0.03 ms

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

### 채점결과

Empty

### 문제 설명

<p>두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.</p>
<div class="highlight"><pre class="codehilite"><code>1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
</code></pre></div>
<p>예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -&gt; "hot" -&gt; "dot" -&gt; "dog" -&gt; "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.</p>

<p>두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>각 단어는 알파벳 소문자로만 이루어져 있습니다.</li>
<li>각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.</li>
<li>words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.</li>
<li>begin과 target은 같지 않습니다.</li>
<li>변환할 수 없는 경우에는 0를 return 합니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>begin</th>
<th>target</th>
<th>words</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>"hit"</td>
<td>"cog"</td>
<td>["hot", "dot", "dog", "lot", "log", "cog"]</td>
<td>4</td>
</tr>
<tr>
<td>"hit"</td>
<td>"cog"</td>
<td>["hot", "dot", "dog", "lot", "log"]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>예제 #1<br>
문제에 나온 예와 같습니다.</p>

<p>예제 #2<br>
target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
