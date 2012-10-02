package crux;

/**
 * Representation of a crux token.
 */
public class Token {
	/**
	 * Enumeration of all possible token types in the crux language.
	 */
	public static enum Kind {
		// Logical.
		AND("and"),
		OR("or"),
		NOT("not"),
		
		// Arithmetical.
		ADD("+"),
		SUB("-"),
		MUL("*"),
		DIV("/"),
		
		IDENTIFIER(),

		// Types.
		INTEGER(),
		FLOAT(),

		// Misc.
		ERROR(),
		EOF();
		
		// TODO complete the list of possible tokens
		
		private String default_lexeme;
		
		/**
		 * Construct a token type enum with a default lexemes.
		 */
		Kind()
		{
			default_lexeme = "";
		}
		
		/**
		 * Construct a token type enum with a given lexeme.
		 */
		Kind(String lexeme)
		{
			default_lexeme = lexeme;
		}
		
		/**
		 * Answerers the question whether this token type has a static lexeme or not.
		 * @return true if it has a static lexeme
		 * @return false otherwise.
		 */
		public boolean hasStaticLexeme()
		{
			return default_lexeme != null;
		}
		
		// TODO OPTIONAL: if you wish to also make convenience functions, feel free
		//           for example, boolean matches(String lexeme)
		//           can report whether a Token.Kind has the given lexeme
	}
	
	/* The line number of the lexeme. */
	private int lineNum;

	/* The character position of the beginning of the lexeme. */
	private int charPos;
	
	/* The kind of token the lexeme is of. */
	Kind kind;

	/* The actual instance of the token. */
	private String lexeme = "";
	
	
	// TODO OPTIONAL: implement factory functions for some tokens, as you see fit.
	/*
	public static Token EOF(int linePos, int charPos)
	{
		Token tok = new Token(linePos, charPos);
		tok.kind = Kind.EOF;
		return tok;
	}
	*/

	/**
	 * Instantiate a token with line number and char position.
	 * @param lineNum The line number the lexeme was found at.
	 * @param charPos The character position on the line the lexeme was found on.
	 */
	private Token(int lineNum, int charPos)
	{
		this.lineNum = lineNum;
		this.charPos = charPos;
		
		// If we don't match anything, signal error.
		this.kind = Kind.ERROR;
		this.lexeme = "No Lexeme Given";
	}
	
	 * Instantiate a token with line number and char position.
	 * @param lexeme The found lexeme string.
	 * @param lineNum The line number the lexeme was found at.
	 * @param charPos The character position on the line the lexeme was found on.
	 */
	public Token(String lexeme, int lineNum, int charPos)
	{
		this.lineNum = lineNum;
		this.charPos = charPos;
		
		// TODO Based on the given lexeme determine and set the actual kind.
		
		// If we don't match anything, signal error.
		this.kind = Kind.ERROR;
		this.lexeme = "Unrecognized lexeme: " + lexeme;
	}
	
	/**
	 * Get the line number of the lexeme.
	 * @return The line number.
	 */
	public int getLineNumber()
	{
		return lineNum;
	}
	
	/**
	 * Get the character position of the lexeme.
	 * @return The character position.
	 */
	public int getCharPosition()
	{
		return charPos;
	}

	/**
	 * Return the lexeme representing or held by this token.
	 * @return The lexeme string.
	 */
	public String lexeme()
	{
		// TODO implement
		return null;
	}

	/**
	 * Get a string represenation of this token instance.
	 * @return A formatted string describing the token.
	 */
	public String toString()
	{
		// TODO implement this
		throw new UnsupportedOperationException();
		return "Not Yet Implemented";
	}

	// TODO OPTIONAL: function to query a token about its kind
	//           boolean is(Token.Kind kind)

	// TODO OPTIONAL: add any additional helper or convenience methods
	//           that you find make for a clean design
}