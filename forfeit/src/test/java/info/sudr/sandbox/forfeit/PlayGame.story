package info.sudr.sandbox.forfeit

scenario "ignores numbers divisible by 7", {
	given "a forfeit game", {
		game = new Game()
	}
	
	when 'we play for 100', {
		result = game.play(100)
		println result
	}
	
	then 'numbers divisible by 7 are not present', {
		result.each { n -> 
			n.mod(7).shouldNotEqual 0
		}
	}
}