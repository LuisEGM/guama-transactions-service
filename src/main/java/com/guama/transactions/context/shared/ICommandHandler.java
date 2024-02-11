package com.guama.transactions.context.shared;

import com.cloudogu.cb.CommandHandler;

/**
 * Command handler interface
 *
 * @param <R> Class to be returned
 * @param <C> A command class
 */
public interface ICommandHandler<R, C extends ICommand<R>> extends CommandHandler<R, C> {
}
