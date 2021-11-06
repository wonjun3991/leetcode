var rotate = function (matrix) {
  let start = 0;
  let end = matrix.length - 1;
  while (start < end) {
    rotateFrame(matrix, start, end);
    start++;
    end--;
  }
  return matrix;
};

function rotateFrame(matrix, start, end) {
  let temp = 0;
  for (let i = start; i < end; i++) {
    temp = matrix[start][i];
    matrix[start][i] = matrix[end - (i - start)][start];
    matrix[end - (i - start)][start] = matrix[end][end - (i - start)];
    matrix[end][end - (i - start)] = matrix[i][end];
    matrix[i][end] = temp;
  }}