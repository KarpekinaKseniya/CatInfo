package com.self.education.catinfo.resource;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.self.education.catinfo.api.CatsColorInfoResponse;
import com.self.education.catinfo.api.CatsStatResponse;
import com.self.education.catinfo.service.CatsStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/cats-statistic")
public class CatsStatisticResource {

    private final CatsStatisticService catsStatisticService;

    //@formatter:off
    @Operation(summary = "Add or update cat colors info",
            description = "Endpoint for adding/updating information about the number of cats of each color",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "409", description = "Conflict"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    //@formatter:on
    @PostMapping("/cat-colors")
    public ResponseEntity<List<CatsColorInfoResponse>> createCatsColorInfo() {
        return new ResponseEntity<>(catsStatisticService.createCatColorsInfo(), OK);
    }

    //@formatter:off
    @Operation(summary = "Add or update cats statistic information",
            description = "Endpoint for adding/updating statistic information about tail and whiskers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "409", description = "Conflict"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    //@formatter:on
    @PostMapping("/tail-and-whiskers-length")
    public ResponseEntity<CatsStatResponse> createOrUpdateCatsStatistic() {
        return new ResponseEntity<>(catsStatisticService.createOrUpdateCatsStat(), OK);
    }
}