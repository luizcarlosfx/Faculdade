/*package com.faculdade.sistemas_distribuidos;

// a ideia desse é utilizar um conjunto de sensores em um sistema anti roubo
class BuildingMonitor extends Thread 
{
	// 3 sensores, o da janela o da porta e o de movimento
	BuildingSensor win, door, move;
	
	// sirene
	Siren siren = new Siren () ;
	
	// luzes
	Lights lights = new Lights () ;
	
	// sintetizador
	Synthesizer synthesizer = new Synthesizer () ;
	
	// sensores das portas
	DoorSensors doors = new DoorSensors (30) ;
	
	// sensores das janelas
	WindowSensors windows = new WindowSensors (50) ;
	
	// sensores de movimento
	MovementSensors movements = new MovementSensors (200);
	
	// sensor de energia
	PowerMonitor pm = new PowerMonitor () ;

	BuildingMonitor()
	{
	// initializa todos os sensores
	siren.start () ; lights.start () ;
	synthesizer.start () ; windows.start () ;
	doors.start () ; movements.start () ; pm.start();
	}
}*/