package com.guama.transactions.api.controller.transactions.update;

import com.cloudogu.cb.CommandBus;
import com.guama.transactions.context.shared.GuamaTransactionError;
import com.guama.transactions.context.transactions.domain.update.UpdateTransactionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Update transaction controller
 */
@Tag(name = "Transactions", description = "Transactions endpoints")
@RestController
@RequestMapping("/transaction")
public class UpdateTransactionController {

  private final CommandBus commandBus;
  private final ModelMapper modelMapper;

  /**
   * Constructor
   *
   * @param commandBus  The command bus
   * @param modelMapper The model mapper
   */
  public UpdateTransactionController(CommandBus commandBus, ModelMapper modelMapper) {
    this.commandBus = commandBus;
    this.modelMapper = modelMapper;
  }

  @Operation(summary = "Update transaction")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Transaction updated successfully",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateTransactionResponse.class))
      }
    ),
    @ApiResponse(
      responseCode = "400",
      description = "Request parameters are invalid",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = GuamaTransactionError.class))
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
  @PutMapping("/{id}")
  public ResponseEntity<UpdateTransactionResponse> index(
    @Parameter(description = "Transaction id", example = "1")
    @PathVariable Long id,
    @RequestBody UpdateTransactionRequest updateTransactionRequest
  ) {
    var updateTransactionCommand = modelMapper.map(updateTransactionRequest, UpdateTransactionCommand.class);
    updateTransactionCommand.setId(id);
    var transaction = commandBus.execute(updateTransactionCommand);
    return ResponseEntity.ok(UpdateTransactionResponse.toResponse(transaction));
  }
}
