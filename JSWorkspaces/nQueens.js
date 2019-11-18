function consoleTest() {
    var n = 10;
    var queens = [];
    var temp = [];
    /**
     * 
     * queen constructor
     */
    function Queen(row, col) {
        var queen = {
            row: row,
            col: col
        };
        return queen;
    }

    while (queens.length > -1 && queens.length < n) {
        if (!place()) {
            try {
                while (!replace())
                    queens.pop();

            } catch (err) {
                break;
            }

        }

    }
    if (queens.length > 0) {
        printBoard();
    } else {
        console.log("No solutions at n = " + n);
    }


    function place() {

    }

    function printBoard() {
        var x = "";
        for (r = 0; r < n; r++) {
            var q = queens.pop();
            for (c = 0; c < n; c++) {
                if (q.col == c)
                // qs[r][c] = "Q";
                    x += "Q  ";
                else
                    x += "X  ";
            }
            console.log(x);
            x = "";
        }
    }

    function checkPosition(row, col) {

        var flag = false;
        while (queens.length > 0) {
            temp.push(queens.pop());

            if (queens[queens.length-1].row == row && queens[queens.length-1].col == col) {
                flag = true;
                break;

            }
        }
        while (temp.length > 0) {
            queens.push(temp.pop());
        }
        return flag;
    }

    function place() {
        var cur = Queen(0, queens.length);

        var placed = false;
        while (!placed && cur.row < n) {
            if (canPlace(cur)) {
                queens.push(cur);
                return true;
            }
            cur = new Queen(cur.getRow() + 1, queens.length);
        }
        return false;
    }

    function replace() {
        cur = Queen(queens.peek().row + 1, queens.pop().col);

        var placed = false;
        while (!placed && cur.getRow() < n) {
            if (canPlace(cur)) {
                queens.push(cur);
                return true;
            }
            cur = Queen(cur.getRow() + 1, queens.length);
        }
        return false;
    }
    function canPlace(cur) {
        if (queens.length == 0) {
            return true;
        }
        var flag = true;

        while (queens.length > 0) {
            temp.push(queens.pop());
            if (queens[queens.length-1].row == cur.row) { // if there is a queen in same row return false
                flag = false;
            } else if (queens[queens.length-1].col == cur.col) {
                flag = false;
            }
            else if (canDiagonal(cur, queens[queens.length-1])) {
                flag = false;
            }
        }
        while (temp.length > 0) {
            queens.push(temp.pop());
        }
        return flag;
    }
    function canDiagonal(cur, placed) {
        for (i = 0; i < n && i > -1; i++) {
            if ((placed.col + i == cur.col && placed.row + i == cur.row)) { // check if it is down
                // left
                return true;
            } else if (placed.col + i == cur.col && placed.row - i == cur.row) { // check if it is
                // up left
                return true;
            }

        }
        return false;
    }
}



    


