// Generated from E:/Projects/Java/LanguageO/src/main/resources\LanguageO.g4 by ANTLR 4.9.2
package org.innopolis.lsd.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LanguageOParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LanguageOParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(LanguageOParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(LanguageOParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(LanguageOParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(LanguageOParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(LanguageOParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(LanguageOParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(LanguageOParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LanguageOParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(LanguageOParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(LanguageOParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(LanguageOParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LanguageOParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageOParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(LanguageOParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LanguageOParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(LanguageOParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(LanguageOParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(LanguageOParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCall(LanguageOParser.FCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorCall(LanguageOParser.ConstructorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(LanguageOParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(LanguageOParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(LanguageOParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(LanguageOParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LanguageOParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageOParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(LanguageOParser.ClassTypeContext ctx);
}