package com.guama.transactions.api.controller.transactions.find;

import com.cloudogu.cb.CommandBus;
import com.guama.transactions.context.shared.GuamaTransactionError;
import com.guama.transactions.context.transactions.domain.find.FindTransactionsView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transactions", description = "Transactions endpoints")
@RestController
@RequestMapping("/transactions")
public class FindTransactionsController {

  private static final String DEFAULT_SORT_PROPERTY = "date";
  private final CommandBus queryBus;

  /**
   * Constructor
   *
   * @param queryBus The query bus
   */
  public FindTransactionsController(CommandBus queryBus) {
    this.queryBus = queryBus;
  }

  @Operation(summary = "Get all transactions")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Found transactions",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = FindTransactionsResponse.class))
      }
    ),
    @ApiResponse(
      responseCode = "400",
      description = "Request parameters are invalid",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = GuamaTransactionError.class))
      }
    )
  })
  @GetMapping
  public ResponseEntity<FindTransactionsResponse> index(
    @Parameter(description = "Transaction name", example = "Transaction1")
    @RequestParam(value = "name", defaultValue = "") String name,
    @Parameter(description = "Transaction state", example = "PAID")
    @RequestParam(value = "status", defaultValue = "") String status,
    @Parameter(description = "From date", example = "2023-01-01 00:00:00")
    @RequestParam(value = "fromDate", defaultValue = "") String fromDate,
    @Parameter(description = "To date", example = "2023-01-05 00:00:00")
    @RequestParam(value = "toDate", defaultValue = "") String toDate,
    @Parameter(description = "Page number")
    @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
    @Parameter(description = "Page size")
    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
    @Parameter(description = "Sort direction")
    @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection
  ) {
    var findTransactionsView = FindTransactionsView.builder()
      .pageable(FindTransactionsView.PageableParameters.builder()
        .pageNumber(pageNumber >= 1 ? pageNumber - 1 : 0)
        .pageSize(pageSize)
        .sort(DEFAULT_SORT_PROPERTY)
        .sortDirection(sortDirection)
        .build())
      .filters(FindTransactionsView.FilterParameters.builder()
        .name(name)
        .status(status)
        .fromDate(fromDate)
        .toDate(toDate)
        .build())
      .build();

    var transactionsPage = queryBus.execute(findTransactionsView);
    return ResponseEntity.ok(FindTransactionsResponse.convertTransactionsPageToTransactionResponse(transactionsPage));
  }
}
