package info.sudr.sandbox.forfeit

scenario "ignores numbers divisible by 7", {
	given "a forfeit game for 100", {
		game = new Game(100)
	}
	
	when 'we play', {
		result = game.play()
	}
	
	then 'numbers divisible by 7 are not present', {
		result.each { n -> 
			n.mod(7).shouldNotEqual 0
		}
	}
}