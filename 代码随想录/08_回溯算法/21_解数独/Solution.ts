function solveSudoku(board: string[][]): void {
    const dfs = () => {
        for (let x = 0; x < 9; x++) {
            for (let y = 0; y < 9; y++) {
                if (board[x][y] != '.') continue;
                for (let k = 1; k <= 9; k++) {
                    if (check(x, y, String(k))) {
                        board[x][y] = String(k)
                        if (dfs()) return true;
                        board[x][y] = '.'
                    }
                }
                return false;
            }
        }
        return true;
    }
    const check = (x: number, y: number, k: string): boolean => {
        for (let i = 0; i < 9; i++)
            if (board[x][i] === k || board[i][y] === k)
                return false
        let xx = ((x / 3) >> 0) * 3, yy = ((y / 3) >> 0) * 3
        for (let i = xx; i <= xx + 2; i++)
            for (let j = yy; j <= yy + 2; j++)
                if (board[i][j] === k) return false;
        return true
    }
    dfs()
};