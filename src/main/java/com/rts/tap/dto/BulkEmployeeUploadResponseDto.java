package com.rts.tap.dto;

import java.util.List;

public class BulkEmployeeUploadResponseDto {

    private List<BulkEmployeeCreationDto> inserted;  // List of successfully inserted employee data
    private List<BulkEmployeeCreationDto> skipped;   // List of employees that were skipped (e.g., already exist)
    private List<BulkEmployeeCreationDto> failed;    // List of employees that failed to insert

    private int totalProcessed;       // Total number of employees processed in the bulk upload
    private int totalInserted;        // Number of employees successfully inserted
    private int totalSkipped;         // Number of employees skipped
    private int totalFailed;          // Number of employees failed to insert

    // Getters and Setters
    public List<BulkEmployeeCreationDto> getInserted() {
        return inserted;
    }

    public void setInserted(List<BulkEmployeeCreationDto> inserted) {
        this.inserted = inserted;
    }

    public List<BulkEmployeeCreationDto> getSkipped() {
        return skipped;
    }

    public void setSkipped(List<BulkEmployeeCreationDto> skipped) {
        this.skipped = skipped;
    }

    public List<BulkEmployeeCreationDto> getFailed() {
        return failed;
    }

    public void setFailed(List<BulkEmployeeCreationDto> failed) {
        this.failed = failed;
    }

    public int getTotalProcessed() {
        return totalProcessed;
    }

    public void setTotalProcessed(int totalProcessed) {
        this.totalProcessed = totalProcessed;
    }

    public int getTotalInserted() {
        return totalInserted;
    }

    public void setTotalInserted(int totalInserted) {
        this.totalInserted = totalInserted;
    }

    public int getTotalSkipped() {
        return totalSkipped;
    }

    public void setTotalSkipped(int totalSkipped) {
        this.totalSkipped = totalSkipped;
    }

    public int getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(int totalFailed) {
        this.totalFailed = totalFailed;
    }

    // Constructor for easy initialization
    public BulkEmployeeUploadResponseDto(List<BulkEmployeeCreationDto> inserted, List<BulkEmployeeCreationDto> skipped, 
                                          List<BulkEmployeeCreationDto> failed, int totalProcessed, int totalInserted, 
                                          int totalSkipped, int totalFailed) {
        this.inserted = inserted;
        this.skipped = skipped;
        this.failed = failed;
        this.totalProcessed = totalProcessed;
        this.totalInserted = totalInserted;
        this.totalSkipped = totalSkipped;
        this.totalFailed = totalFailed;
    }

    // Override toString method for better logging
    @Override
    public String toString() {
        return "BulkEmployeeUploadResponseDto{" +
               "inserted=" + inserted +
               ", skipped=" + skipped +
               ", failed=" + failed +
               ", totalProcessed=" + totalProcessed +
               ", totalInserted=" + totalInserted +
               ", totalSkipped=" + totalSkipped +
               ", totalFailed=" + totalFailed +
               '}';
    }
}
