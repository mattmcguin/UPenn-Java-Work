// Author: Matt McGuiness
package battleship;

public abstract class Ship {
    
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit = new boolean[8];
    
    public Ship(int length) {
	this.length = length;
	this.hit = new boolean[length];
    }
    
    public int getBowRow() {
        return bowRow;
    }
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }
    public int getBowColumn() {
        return bowColumn;
    }
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isHorizontal() {
        return horizontal;
    }
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    public boolean[] getHit() {
        return hit;
    }
    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
    
    abstract String getShipType();
    
    /**
     * Returns true if it is okay to put a ship of this length with its 
     * bow in this location, with the given orientation, and returns false otherwise
     * 
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	// Check if row and column are in bounds
	if (row < 0 || row > 19 || column < 0 || column > 19) return false;
	
	// Check if the initial spot is occupied
	if (ocean.isOccupied(row, column)) return false;
	
	
	if (horizontal) {
	    // Ship is out of bounds
	    if (column + this.length > 19) return false;
	    
	    // Touches another ship horizontally(left or right)
	    if (ocean.isOccupied(row, column - 1) || ocean.isOccupied(row, column + this.length)) return false;
	    
	    // Check if it touches diagonally or vertically
	    for (int i = column; i < column + this.length; i++) {
		// Check length of ship
		if (ocean.isOccupied(row, i)) return false;
		
		if (row > 0) {
		    // Check row above ship
		    if (ocean.isOccupied(row - 1, i)) return false;
		    
		    // Check top left corner
		    if (ocean.isOccupied(row - 1, column - 1)) return false;
		    // Check top right corner
		    if (ocean.isOccupied(row - 1, column + 1)) return false;
		    
		}
		if (row < 20) {
		 // Check row below ship
		    if (ocean.isOccupied(row + 1, i)) return false;
		    
		    // Check bottom left corner
		    if (ocean.isOccupied(row + 1, column - 1)) return false;
		    // Check bottom right corner
		    if (ocean.isOccupied(row + 1, column + 1)) return false;
		}
	    }    
	} else {
	 // Ship is out of bounds
	    if (row + this.length > 19) return false;
	    
	    // Touches another ship vertically (top or bottom)
	    if (ocean.isOccupied(row - 1, column) || ocean.isOccupied(row + this.length, column)) return false;
	    
	    // Check if it touches diagonally or vertically
	    for (int i = row; i < row + this.length; i++) {
		// Check length of ship
		if (ocean.isOccupied(i, column)) return false;
		
		if (column > 0) {
		    // Check column to the left of the ship
		    if (ocean.isOccupied(i, column - 1)) return false;
		    
		    // Check top left corner
		    if (ocean.isOccupied(row - 1, column - 1)) return false;
		    // Check top right corner
		    if (ocean.isOccupied(row - 1, column + 1)) return false;
		    
		}
		if (column < 20) {
		 // Check column to the right of the ship
		    if (ocean.isOccupied(i, column + 1)) return false;
		    
		    // Check bottom left corner
		    if (ocean.isOccupied(row + 1, column - 1)) return false;
		    // Check bottom right corner
		    if (ocean.isOccupied(row + 1, column + 1)) return false;
		}
	    }    
	}
	return true;
    }
    
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	this.bowRow = row;
	this.bowColumn = column;
	this.horizontal = horizontal;
	
	if (horizontal) {
	    for (int i = column; i < column + this.length; i++) {
		ocean.ships[row][i] = this;
	    }
	} else {
	    for (int i = row; i < row + this.length; i++) {
		ocean.ships[i][column] = this;
	    }
	}
    }
    
    boolean shootAt(int row, int column) {
	if (row < 0 || row > 19 || column < 0 || column > 19) return false;
	if (this.isSunk()) return false;
	
	if (this.horizontal) {
	    if (row == this.bowRow && this.bowColumn <= column && column < this.bowColumn + this.length) {
		this.hit[column % this.length] = true;
		return true;
	    }
	} else {
	    if (column == this.bowColumn && this.bowRow <= row && row < this.bowRow + this.length) {
		this.hit[row % this.length] = true;
		return true;
	    }
	}
	
	return false;
    }
    
    boolean isSunk() {
	for (int i = 0; i < this.length; i++) {
	    if (this.hit[i] != true) return false;
	}
	
	return true;
    }
    
    @Override
    public String toString() {
        if (this.isSunk()) {
            return "x";
        } else {
            return "S";
        }
    }

}
