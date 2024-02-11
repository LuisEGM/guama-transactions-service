package com.guama.transactions.api.controller.transactions.delete;

import com.cloudogu.cb.CommandBus;
import com.guama.transactions.context.shared.GuamaTransactionError;
import com.guama.transactions.context.transactions.domain.delete.DeleteTransactionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transactions", description = "Transactions endpoints")
@RestController
@RequestMapping("/transaction")
public class DeleteTransactionController {

  private final CommandBus commandBus;

  /**
   * Constructor
   *
   * @param commandBus The command bus
   */
  public DeleteTransactionController(CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @Operation(summary = "Delete transaction")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Transaction deleted successfully",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteTransactionResponse.class))
      }
    ),
    @ApiResponse(
      responseCode = "404",
      description = "Transaction not found",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = GuamaTransactionError.class))
      }
    )
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<DeleteTransactionResponse> index(
    @Parameter(description = "Transaction id", example = "1")
    @PathVariable Long id
  ) {
    commandBus.execute(new DeleteTransactionCommand(id));
    return ResponseEntity.ok(DeleteTransactionResponse.create(id));
  }
}
