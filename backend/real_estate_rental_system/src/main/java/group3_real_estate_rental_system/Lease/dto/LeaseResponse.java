package group3_real_estate_rental_system.Lease.dto;

import group3_real_estate_rental_system.common.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class LeaseResponse extends BaseResponse {
    private List<LeaseDTO> leases = new ArrayList<>();

    public LeaseResponse() {
    }

    public List<LeaseDTO> getLeases() {
        return leases;
    }

    public void setLeases(List<LeaseDTO> leases) {
        this.leases = leases;
    }
}
