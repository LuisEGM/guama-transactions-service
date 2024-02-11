package com.guama.transactions.api.controller.transactions.create;

import com.cloudogu.cb.CommandBus;
import com.guama.transactions.api.controller.transactions.find.FindTransactionsResponse;
import com.guama.transactions.context.shared.GuamaTransactionError;
import com.guama.transactions.context.transactions.domain.create.CreateTransactionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create Transaction Controller
 */
@Tag(name = "Transactions", description = "Transactions endpoints")
@RestController
@RequestMapping("/transaction")
public class CreateTransactionController {

  private final CommandBus commandBus;
  private final ModelMapper modelMapper;

  /**
   * Constructor
   *
   * @param commandBus  The command bus
   * @param modelMapper The model mapper
   */
  public CreateTransactionController(CommandBus commandBus, ModelMapper modelMapper) {
    this.commandBus = commandBus;
    this.modelMapper = modelMapper;
  }

  @Operation(summary = "Create transaction")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Transaction created successfully",
      content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = CreateTransactionRequest.class))
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
  @PostMapping
  public ResponseEntity<CreateTransactionResponse> index(@RequestBody CreateTransactionRequest createTransactionRequest) {
    var createTransactionCommand = modelMapper.map(createTransactionRequest, CreateTransactionCommand.class);
    var transaction = commandBus.execute(createTransactionCommand);
    return ResponseEntity.ok(CreateTransactionResponse.toResponse(transaction));
  }
}
