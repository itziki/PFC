
public class ia {
	minimax(in game board, in int depth, in int max_depth,
	        out score chosen_score, out score chosen_move)
	begin 
	    if (depth = max_depth) then
	        chosen_score = evaluation(board);
	    else 
	        moves_list = generate_moves(board);
	        if (moves_list = NULL) then
	            chosen_score = evaluation(board);
	        else 
	            for (i = 1 to moves_list.length) do
	                best_score = infinity;
	                new_board = board;
	                apply_move(new_board, moves_list[i]);
	                minimax(new_board, depth+1, max_depth, the_score, the_move);
	                if (better(the_score, best_score)) then
	                    best_score = the_score;
	                    best_move = the_move;
	                endif
	            enddo
	            chosen_score = best_score;
	            chosen_move = best_move;
	        endif
	    endif
	end.
}
