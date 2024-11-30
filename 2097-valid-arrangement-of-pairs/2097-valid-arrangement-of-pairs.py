from collections import defaultdict, deque
class Solution:
    def validArrangement(self, pairs):
        # 그래프 및 입출차수 초기화
        graph = defaultdict(deque)
        indegree = defaultdict(int)
        outdegree = defaultdict(int)
        
        # 그래프 구성
        for start, end in pairs:
            graph[start].append(end)
            outdegree[start] += 1
            indegree[end] += 1
        
        # 오일러 경로의 시작점 찾기
        start_node = pairs[0][0]  # 기본 시작점
        for node in graph:
            if outdegree[node] - indegree[node] == 1:  # 시작점 조건
                start_node = node
                break
        
        # 오일러 경로 탐색 (DFS)
        result = []
        def dfs(node):
            while graph[node]:
                next_node = graph[node].popleft()
                dfs(next_node)
            result.append(node)
        
        dfs(start_node)
        
        # 결과 정렬 (역순으로 구했으므로 뒤집기)
        result.reverse()
        
        # 쌍으로 변환
        return [[result[i], result[i + 1]] for i in range(len(result) - 1)]
        