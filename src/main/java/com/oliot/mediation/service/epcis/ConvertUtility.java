package com.oliot.mediation.service.epcis;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oliot.model.fiware.Subscribition;
import com.oliot.model.fiware.Alert.Alert;
import com.oliot.model.fiware.Building.Building;
import com.oliot.model.fiware.Building.BuildingOperation;
import com.oliot.model.fiware.Bus.BusEstimation;
import com.oliot.model.fiware.Bus.BusLine;
import com.oliot.model.fiware.Bus.BusStop;
import com.oliot.model.fiware.CivicIssueTracking.Open311ServiceRequest;
import com.oliot.model.fiware.CivicIssueTracking.Open311ServiceType;
import com.oliot.model.fiware.Device.Device;
import com.oliot.model.fiware.Device.DeviceModel;
import com.oliot.model.fiware.Environment.AeroAllergenObserved;
import com.oliot.model.fiware.Environment.AirQualityObserved;
import com.oliot.model.fiware.Environment.NoiseLevelObserved;
import com.oliot.model.fiware.Environment.WaterQualityObserved;
import com.oliot.model.fiware.Indicator.KeyPerformanceIndicator;
import com.oliot.model.fiware.Parking.OffStreetParking;
import com.oliot.model.fiware.Parking.OnStreetParking;
import com.oliot.model.fiware.Parking.ParkingAccess;
import com.oliot.model.fiware.Parking.ParkingGroup;
import com.oliot.model.fiware.Parking.ParkingSpot;
import com.oliot.model.fiware.ParksAndGardens.FlowerBed;
import com.oliot.model.fiware.ParksAndGardens.Garden;
import com.oliot.model.fiware.ParksAndGardens.GreenspaceRecord;
import com.oliot.model.fiware.ParksAndGardens.Park;
import com.oliot.model.fiware.PointOfInterest.Beach;
import com.oliot.model.fiware.PointOfInterest.Museum;
import com.oliot.model.fiware.PointOfInterest.PointOfInterest;
import com.oliot.model.fiware.PointOfInterest.TouristInformationCenter;
import com.oliot.model.fiware.StreetLighting.Streetlight;
import com.oliot.model.fiware.StreetLighting.StreetlightControlCabinet;
import com.oliot.model.fiware.StreetLighting.StreetlightGroup;
import com.oliot.model.fiware.StreetLighting.StreetlightModel;
import com.oliot.model.fiware.Test.Car;
import com.oliot.model.fiware.Test.Room;
import com.oliot.model.fiware.Transportation.Road;
import com.oliot.model.fiware.Transportation.TrafficFlowObserved;
import com.oliot.model.fiware.Transportation.Vehicle;
import com.oliot.model.fiware.Transportation.VehicleModel;
import com.oliot.model.fiware.WasteManagement.WasteContainer;
import com.oliot.model.fiware.WasteManagement.WasteContainerIsle;
import com.oliot.model.fiware.WasteManagement.WasteContainerModel;
import com.oliot.model.fiware.Weather.WeatherAlarm;
import com.oliot.model.fiware.Weather.WeatherForecast;
import com.oliot.model.fiware.Weather.WeatherObserved;

public class ConvertUtility {
	
	public static Room getRoom(String body) {
		Room room =new Room();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			room = gson.fromJson(body, Room.class); 
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
		}
		return room;
	}
	
	public static Car getCar(String body) {
		Car car =new Car();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			car = gson.fromJson(body, Car.class);
		}
		return car;
	}
	
	//--------------------------------Bus System 
	public static BusEstimation getBusEstimation(String body) {
		System.out.println(body);
		BusEstimation busEstimation=new BusEstimation();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busEstimation = gson.fromJson(body, BusEstimation.class);
		}
		return busEstimation;
		
	}
	
	public static List<BusEstimation> getBusEstimationList(String body) {
		System.out.println(body);
		List<BusEstimation> busEstimationList=new ArrayList<BusEstimation>();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			Type BusStopListType=new TypeToken<ArrayList<BusEstimation>>() {}.getType();
			busEstimationList = gson.fromJson(body, BusStopListType);
		}
		return busEstimationList;
		
	}
	
	public static BusStop getBusStop(String body) {
		BusStop busStop=new BusStop();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busStop = gson.fromJson(body, BusStop.class);
		}
		return busStop;
		
	}
	public static List<BusStop> getBusStopList(String body) {
		List<BusStop> busStopList=new ArrayList<BusStop>();
		if(body!=null) {
			Type BusStopListType=new TypeToken<ArrayList<BusStop>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			busStopList = gson.fromJson(body, BusStopListType);
		}
		return busStopList;
		
	}
	
	public static BusLine getBusLine(String body) {
		BusLine busLine=new BusLine();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busLine = gson.fromJson(body, BusLine.class);
		}
		return busLine;
		
	}
	public static List<BusLine> getBusLineList(String body) {
		List<BusLine> busLineList=new ArrayList<BusLine>();
		if(body!=null) {
			Type BusLineListType=new TypeToken<ArrayList<BusLine>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			busLineList = gson.fromJson(body, BusLineListType);
		}
		return busLineList;
		
	}
	
	public static Alert getAlert(String body) {
		Alert alert =new Alert();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			alert = gson.fromJson(body, Alert.class);
		}
		return alert;
	}
	
	public static Building getBuilding(String body) {
		Building building =new Building();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			building = gson.fromJson(body, Building.class);
		}
		return building;
	}
	
	public static BuildingOperation getBuildingOperation(String body) {
		BuildingOperation buildingOperation =new BuildingOperation();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			buildingOperation = gson.fromJson(body, BuildingOperation.class);
		}
		return buildingOperation;
	}
	
	public static Open311ServiceRequest getOpen311ServiceRequest(String body) {
		Open311ServiceRequest open311ServiceRequest =new Open311ServiceRequest();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			open311ServiceRequest = gson.fromJson(body, Open311ServiceRequest.class);
		}
		return open311ServiceRequest;
	}
	
	public static Open311ServiceType getOpen311ServiceType(String body) {
		Open311ServiceType open311ServiceType =new Open311ServiceType();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			open311ServiceType = gson.fromJson(body, Open311ServiceType.class);
		}
		return open311ServiceType;
	}
	public static Device getDevice(String body) {
		Device device =new Device();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			device = gson.fromJson(body, Device.class);
		}
		return device;
	}
	
	public static DeviceModel getDeviceModel(String body) {
		DeviceModel deviceModel =new DeviceModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			deviceModel = gson.fromJson(body, DeviceModel.class);
		}
		return deviceModel;
	}
	
	public static AeroAllergenObserved getAeroAllergenObserved(String body) {
		AeroAllergenObserved aeroAllergenObserved =new AeroAllergenObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			aeroAllergenObserved = gson.fromJson(body, AeroAllergenObserved.class);
		}
		return aeroAllergenObserved;
	}
	
	public static AirQualityObserved getAirQualityObserved(String body) {
		AirQualityObserved airQualityObserved =new AirQualityObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			airQualityObserved = gson.fromJson(body, AirQualityObserved.class);
		}
		return airQualityObserved;
	}
	
	public static NoiseLevelObserved getNoiseLevelObserved(String body) {
		NoiseLevelObserved noiseLevelObserved =new NoiseLevelObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			noiseLevelObserved = gson.fromJson(body, NoiseLevelObserved.class);
		}
		return noiseLevelObserved;
	}
	
	public static WaterQualityObserved getWaterQualityObserved(String body) {
		WaterQualityObserved waterQualityObserved =new WaterQualityObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			waterQualityObserved = gson.fromJson(body, WaterQualityObserved.class);
		}
		return waterQualityObserved;
	}
	
	public static KeyPerformanceIndicator getKeyPerformanceIndicator(String body) {
		KeyPerformanceIndicator keyPerformanceIndicator =new KeyPerformanceIndicator();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			keyPerformanceIndicator = gson.fromJson(body, KeyPerformanceIndicator.class);
		}
		return keyPerformanceIndicator;
	}
	
	public static OffStreetParking getOffStreetParking(String body) {
		OffStreetParking offStreetParking =new OffStreetParking();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			offStreetParking = gson.fromJson(body, OffStreetParking.class);
		}
		return offStreetParking;
	}
	
	public static OnStreetParking getOnStreetParking(String body) {
		OnStreetParking onStreetParking =new OnStreetParking();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			onStreetParking = gson.fromJson(body, OnStreetParking.class);
		}
		return onStreetParking;
	}
	
	public static ParkingAccess getParkingAccess(String body) {
		ParkingAccess parkingAccess =new ParkingAccess();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingAccess = gson.fromJson(body, ParkingAccess.class);
		}
		return parkingAccess;
	}
	
	public static ParkingGroup getParkingGroup(String body) {
		ParkingGroup parkingGroup =new ParkingGroup();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingGroup = gson.fromJson(body, ParkingGroup.class);
		}
		return parkingGroup;
	}
	
	public static ParkingSpot getParkingSpot(String body) {
		ParkingSpot parkingSpot =new ParkingSpot();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingSpot = gson.fromJson(body, ParkingSpot.class);
		}
		return parkingSpot;
	}
	
	public static FlowerBed getFlowerBed(String body) {
		FlowerBed flowerBed =new FlowerBed();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			flowerBed = gson.fromJson(body, FlowerBed.class);
		}
		return flowerBed;
	}
	
	public static Garden getGarden(String body) {
		Garden garden =new Garden();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			garden = gson.fromJson(body, Garden.class);
		}
		return garden;
	}
	
	public static GreenspaceRecord getGreenspaceRecord(String body) {
		GreenspaceRecord greenspaceRecord =new GreenspaceRecord();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			greenspaceRecord = gson.fromJson(body, GreenspaceRecord.class);
		}
		return greenspaceRecord;
	}
	
	public static Park getPark(String body) {
		Park park =new Park();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			park = gson.fromJson(body, Park.class);
		}
		return park;
	}
	
	public static Beach getBeach(String body) {
		Beach beach =new Beach();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			beach = gson.fromJson(body, Beach.class);
		}
		return beach;
	}
	
	public static Museum getMuseum(String body) {
		Museum museum =new Museum();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			museum = gson.fromJson(body, Museum.class);
		}
		return museum;
	}
	
	public static PointOfInterest getPointOfInterest(String body) {
		PointOfInterest pointOfInterest =new PointOfInterest();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			pointOfInterest = gson.fromJson(body, PointOfInterest.class);
		}
		return pointOfInterest;
	}
	
	public static TouristInformationCenter getTouristInformationCenter(String body) {
		TouristInformationCenter touristInformationCenter =new TouristInformationCenter();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			touristInformationCenter = gson.fromJson(body, TouristInformationCenter.class);
		}
		return touristInformationCenter;
	}
	
	public static Streetlight getStreetlight(String body) {
		Streetlight streetlight =new Streetlight();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlight = gson.fromJson(body, Streetlight.class);
		}
		return streetlight;
	}
	
	public static StreetlightControlCabinet getStreetlightControlCabinet(String body) {
		StreetlightControlCabinet streetlightControlCabinet =new StreetlightControlCabinet();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightControlCabinet = gson.fromJson(body, StreetlightControlCabinet.class);
		}
		return streetlightControlCabinet;
	}
	
	public static StreetlightGroup getStreetlightGroup(String body) {
		StreetlightGroup streetlightGroup =new StreetlightGroup();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightGroup = gson.fromJson(body, StreetlightGroup.class);
		}
		return streetlightGroup;
	}
	
	public static StreetlightModel getStreetlightModel(String body) {
		StreetlightModel streetlightModel =new StreetlightModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightModel = gson.fromJson(body, StreetlightModel.class);
		}
		return streetlightModel;
	}
	
	public static Road getRoad(String body) {
		Road road =new Road();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			road = gson.fromJson(body, Road.class);
		}
		return road;
	}
	
	public static TrafficFlowObserved getTrafficFlowObserved(String body) {
		TrafficFlowObserved trafficFlowObserved =new TrafficFlowObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			trafficFlowObserved = gson.fromJson(body, TrafficFlowObserved.class);
		}
		return trafficFlowObserved;
	}
	
	public static Vehicle getVehicle(String body) {
		Vehicle vehicle =new Vehicle();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			vehicle = gson.fromJson(body, Vehicle.class);
		}
		return vehicle;
	}
	
	public static VehicleModel getVehicleModel(String body) {
		VehicleModel vehicleModel =new VehicleModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			vehicleModel = gson.fromJson(body, VehicleModel.class);
		}
		return vehicleModel;
	}
	
	public static WasteContainer getWasteContainer(String body) {
		WasteContainer wasteContainer =new WasteContainer();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainer = gson.fromJson(body, WasteContainer.class);
		}
		return wasteContainer;
	}
	
	public static WasteContainerIsle getWasteContainerIsle(String body) {
		WasteContainerIsle wasteContainerIsle =new WasteContainerIsle();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainerIsle = gson.fromJson(body, WasteContainerIsle.class);
		}
		return wasteContainerIsle;
	}
	
	public static WasteContainerModel getWasteContainerModel(String body) {
		WasteContainerModel wasteContainerModel =new WasteContainerModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainerModel = gson.fromJson(body, WasteContainerModel.class);
		}
		return wasteContainerModel;
	}
	
	public static WeatherAlarm getWeatherAlarm(String body) {
		WeatherAlarm weatherAlarm =new WeatherAlarm();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherAlarm = gson.fromJson(body, WeatherAlarm.class);
		}
		return weatherAlarm;
	}
	
	public static WeatherForecast getWeatherForecast(String body) {
		WeatherForecast weatherForecast =new WeatherForecast();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherForecast = gson.fromJson(body, WeatherForecast.class);
		}
		return weatherForecast;
	}
	
	public static WeatherObserved geWeatherObserved(String body) {
		WeatherObserved weatherObserved =new WeatherObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherObserved = gson.fromJson(body, WeatherObserved.class);
		}
		return weatherObserved;
	}
	
	
	
	public static ObjectEventType translate(Room room) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgtin:88000269." + room.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		readPoint.setId("urn:epc:id:sgln:8800026900016." + room.getId());
		objectEventType.setReadPoint(readPoint);

		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
		businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + room.getId());
		objectEventType.setBizLocation(businessLocation);

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
		businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			
			if(room.getId()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/id", "oliot:Fiware");
				id.setTextContent(room.getId());
				elementList.add(id);
			}
			
			

			if(room.getType()!=null) {
				Element type = doc.createElementNS("http://ns.oliot.com/type", "oliot:Fiware");
				type.setTextContent(room.getType());
				elementList.add(type);
			}
			
			if(room.getTemperature()!=null) {
				Element temprature = doc.createElementNS("http://ns.oliot.com/temprature", "oliot:Fiware");
				
				if(room.getTemperature().getType()!=null) {
					Element tempratureType = doc.createElementNS("http://ns.oliot.com/temprature/type", "oliot:Fiware");
					tempratureType.setTextContent(room.getTemperature().getType());
					
					temprature.appendChild(tempratureType);
				}
				if(room.getTemperature().getValue()!=null) {
					Element tempratureValue = doc.createElementNS("http://ns.oliot.com/temprature/value", "oliot:Fiware");
					tempratureValue.setTextContent(room.getTemperature().getValue().toString());
					
					temprature.appendChild(tempratureValue);
				}
				if(room.getTemperature().getMetadat()!=null) {
					Element tempratureMetadat = doc.createElementNS("http://ns.oliot.com/temprature/metadata", "oliot:Fiware");
					tempratureMetadat.setTextContent(room.getTemperature().getValue().toString());
					
					temprature.appendChild(tempratureMetadat);
				}
				
				elementList.add(temprature);
			}
			if(room.getPressure()!=null) {
				Element temprature = doc.createElementNS("http://ns.oliot.com/Pressure", "oliot:Fiware");
				
				if(room.getPressure().getType()!=null) {
					Element PressureType = doc.createElementNS("http://ns.oliot.com/Pressure/type", "oliot:Fiware");
					PressureType.setTextContent(room.getTemperature().getType());
					
					temprature.appendChild(PressureType);
				}
				if(room.getPressure().getValue()!=null) {
					Element PressureValue = doc.createElementNS("http://ns.oliot.com/pressure/value", "oliot:Fiware");
					PressureValue.setTextContent(room.getTemperature().getValue().toString());
					
					temprature.appendChild(PressureValue);
				}
				if(room.getPressure().getMetadat()!=null) {
					Element PressureMetadat = doc.createElementNS("http://ns.oliot.com/pressure/metadata", "oliot:Fiware");
					PressureMetadat.setTextContent(room.getTemperature().getMetadat().toString());
					
					temprature.appendChild(PressureMetadat);
				}
				
				elementList.add(temprature);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	public static ObjectEventType translate(Car car) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
				//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
				objectEventType.setEventTime(Calendar.getInstance());
				objectEventType.setRecordTime(Calendar.getInstance());
				int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
				//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
				String offset="00";
				if(offsetInt<10 && offsetInt>=0) {
					offset="+0"+offsetInt;
				}else if(offsetInt>-10 && offsetInt<0) {
					offset="-0"+(-offsetInt);
				}
				//System.out.println("offset : "+offset);
				objectEventType.setEventTimeZoneOffset(offset+":00");
				
				//System.out.println(objectEventType.getEventTimeZoneOffset());

				//objectEventType.setEventTimeZoneOffset("-06:00");

				EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
				epcisEventExtension.setEventID(UUID.randomUUID().toString());
				objectEventType.setBaseExtension(epcisEventExtension);

				EPCListType objectEventEPCs = new EPCListType();
				EPC epc1 = new EPC();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				epc1.setValue("urn:epc:id:sgtin:88000269." + car.getId());	
				objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
				objectEventType.setEpcList(objectEventEPCs);
				
				//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
				//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + car.getId());
				//objectEventType.setBaseExtension(eventExtention);

				
				objectEventType.setAction(ActionType.fromValue("OBSERVE"));
				
				objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:car");
				
				objectEventType.setDisposition("urn:epcglobal:cbv:disp:carSensor");

				ReadPointType readPoint = new ReadPointType();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				readPoint.setId("urn:epc:id:sgln:8800026900016." + car.getId());
				objectEventType.setReadPoint(readPoint);

				BusinessLocationType businessLocation = new BusinessLocationType();
				//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
				businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + car.getId());
				objectEventType.setBizLocation(businessLocation);

				BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
				BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
				businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
				businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
				businessTransactionList.getBizTransactions().add(businessTransaction1);
				objectEventType.setBizTransactionList(businessTransactionList);

				List<Object> elementList = new ArrayList<Object>();

				try {
					Document doc;
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = dbf.newDocumentBuilder();
					doc = builder.newDocument();

					if(car.getId()!=null) {
						Element id = doc.createElementNS("http://ns.oliot.com/id", "oliot:Fiware");
						id.setTextContent(car.getId());
						elementList.add(id);
					}
					

					if(car.getType()!=null) {
						Element type = doc.createElementNS("http://ns.oliot.com/type", "oliot:Fiware");
						type.setTextContent(car.getType());
						elementList.add(type);
					}
						
					if(car.getSpeed()!=null) {
						Element speed = doc.createElementNS("http://ns.oliot.com/speed", "oliot:Fiware");
						
						if(car.getSpeed().getType()!=null) {
							Element tempratureType = doc.createElementNS("http://ns.oliot.com/speed/type", "oliot:Fiware");
							tempratureType.setTextContent(car.getSpeed().getType());
							
							speed.appendChild(tempratureType);
						}
						if(car.getSpeed().getValue()!=null) {
							Element tempratureValue = doc.createElementNS("http://ns.oliot.com/speed/value", "oliot:Fiware");
							tempratureValue.setTextContent(car.getSpeed().getValue().toString());
							
							speed.appendChild(tempratureValue);
						}
						if(car.getSpeed().getMetadat()!=null) {
							Element tempratureMetadat = doc.createElementNS("http://ns.oliot.com/speed/metadata", "oliot:Fiware");
							tempratureMetadat.setTextContent(car.getSpeed().getMetadat().toString());
							
							speed.appendChild(tempratureMetadat);
						}
						
						elementList.add(speed);
					}
					
					
					
					

				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				objectEventType.setAnies(elementList);
				
		return objectEventType;
	}
	
	public static ObjectEventType translate(BusEstimation busEstimation) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
				//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
				objectEventType.setEventTime(Calendar.getInstance());
				objectEventType.setRecordTime(Calendar.getInstance());
				int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
				//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
				String offset="00";
				if(offsetInt<10 && offsetInt>=0) {
					offset="+0"+offsetInt;
				}else if(offsetInt>-10 && offsetInt<0) {
					offset="-0"+(-offsetInt);
				}
				//System.out.println("offset : "+offset);
				objectEventType.setEventTimeZoneOffset(offset+":00");
				
				//System.out.println(objectEventType.getEventTimeZoneOffset());

				//objectEventType.setEventTimeZoneOffset("-06:00");

				EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
				epcisEventExtension.setEventID(UUID.randomUUID().toString());
				objectEventType.setBaseExtension(epcisEventExtension);

				EPCListType objectEventEPCs = new EPCListType();
				EPC epc1 = new EPC();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				epc1.setValue(busEstimation.getId());	
				objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
				objectEventType.setEpcList(objectEventEPCs);
				
				//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
				//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
				//objectEventType.setBaseExtension(eventExtention);

				
				objectEventType.setAction(ActionType.fromValue("OBSERVE"));
				
				objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
				
				objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the_line");
                
				
				if(busEstimation.getGeolocation()!=null)
					if(busEstimation.getGeolocation().getValue()!= null)
						if(busEstimation.getGeolocation().getValue().getType().equals("Point"))
							System.out.println(busEstimation.getGeolocation().getValue().getType());
							if(busEstimation.getGeolocation().getValue().getCoordinates()!=null) {
								List<Double> coordinates=busEstimation.getGeolocation().getValue().getCoordinates();
								String sgln=Utility.coordinta_sgln_converter(coordinates.get(0),coordinates.get(1));
								
								ReadPointType readPoint = new ReadPointType();
								//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
								
								readPoint.setId(sgln);
								objectEventType.setReadPoint(readPoint);

								BusinessLocationType businessLocation = new BusinessLocationType();
								//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
								businessLocation.setId(sgln);
								objectEventType.setBizLocation(businessLocation);
							}
				

				BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
				BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
				businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
				businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
				businessTransactionList.getBizTransactions().add(businessTransaction1);
				objectEventType.setBizTransactionList(businessTransactionList);

				List<Object> elementList = new ArrayList<Object>();

				try {
					Document doc;
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = dbf.newDocumentBuilder();
					doc = builder.newDocument();
					
					if(busEstimation.getId()!=null) {
						Element id = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:id", "oliot:Fiware");
						id.setTextContent(busEstimation.getId());
						elementList.add(id);
					}
										

					if(busEstimation.getType()!=null) {
						Element type = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:type", "oliot:Fiware");
						type.setTextContent(busEstimation.getType());
						elementList.add(type);
					}
					
					if(busEstimation.getCompanyName()!=null) {
						Element companyName = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName", "oliot:Fiware");
						
						if(busEstimation.getCompanyName().getType()!=null) {
							Element shortIDType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:type", "oliot:Fiware");
							shortIDType.setTextContent(busEstimation.getCompanyName().getType());
							
							companyName.appendChild(shortIDType);
						}
						if(busEstimation.getCompanyName().getValue()!=null) {
							Element shortIDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:value", "oliot:Fiware");
							shortIDValue.setTextContent(busEstimation.getCompanyName().getValue().toString());
							
							companyName.appendChild(shortIDValue);
						}
						if(busEstimation.getCompanyName().getMetadat()!=null) {
							Element shortIDMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:metadata", "oliot:Fiware");
							shortIDMetadat.setTextContent(busEstimation.getCompanyName().getValue().toString());
							
							companyName.appendChild(shortIDMetadat);
						}
						
						elementList.add(companyName);
					}
					
					if(busEstimation.getDestinationBusLines()!=null) {
						Element destinationBusLines = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines", "oliot:Fiware");
						
						if(busEstimation.getDestinationBusLines().getType()!=null) {
							Element destinationBusLinesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:type", "oliot:Fiware");
							destinationBusLinesType.setTextContent(busEstimation.getDestinationBusLines().getType());
							
							destinationBusLines.appendChild(destinationBusLinesType);
						}
						if(busEstimation.getDestinationBusLines().getValue()!=null) {
							Element destinationBusLinesDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:value", "oliot:Fiware");
							String listDestination="[";
							for(int i=0; i<busEstimation.getDestinationBusLines().getValue().size(); i++) 
								listDestination+=busEstimation.getDestinationBusLines().getValue().get(i)+",";
							
							listDestination=listDestination.substring(0,listDestination.length()-1)+"]";
							destinationBusLinesDValue.setTextContent(listDestination);
							
							destinationBusLines.appendChild(destinationBusLinesDValue);
						}
						if(busEstimation.getDestinationBusLines().getMetadat()!=null) {
							Element destinationBusLinesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:metadata", "oliot:Fiware");
							destinationBusLinesMetadat.setTextContent(busEstimation.getDestinationBusLines().getValue().toString());
							
							destinationBusLines.appendChild(destinationBusLinesMetadat);
						}
						
						elementList.add(destinationBusLines);
					}
					
					if(busEstimation.getDateModified()!=null) {
						Element dateModified = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified", "oliot:Fiware");
						
						if(busEstimation.getDateModified().getType()!=null) {
							Element dateModifiedType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:type", "oliot:Fiware");
							dateModifiedType.setTextContent(busEstimation.getDateModified().getType());
							
							dateModified.appendChild(dateModifiedType);
						}
						if(busEstimation.getDateModified().getValue()!=null) {
							Element dateModifiedValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:value", "oliot:Fiware");
							dateModifiedValue.setTextContent(busEstimation.getDateModified().getValue().toString());
							
							dateModified.appendChild(dateModifiedValue);
						}
						if(busEstimation.getDateModified().getMetadat()!=null) {
							Element dateModifiedMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:metadata", "oliot:Fiware");
							dateModifiedMetadat.setTextContent(busEstimation.getDateModified().getValue().toString());
							
							dateModified.appendChild(dateModifiedMetadat);
						}
						
						elementList.add(dateModified);
					}
					
					if(busEstimation.getRefBusLine()!=null) {
						Element refBusLine = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine", "oliot:Fiware");
						
						if(busEstimation.getRefBusLine().getType()!=null) {
							Element refBusLineType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:type", "oliot:Fiware");
							refBusLineType.setTextContent(busEstimation.getRefBusLine().getType());
							
							refBusLine.appendChild(refBusLineType);
						}
						if(busEstimation.getRefBusLine().getValue()!=null) {
							Element refBusLineValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:value", "oliot:Fiware");
							refBusLineValue.setTextContent(busEstimation.getRefBusLine().getValue().toString());
							
							refBusLine.appendChild(refBusLineValue);
						}
						if(busEstimation.getShortID().getMetadat()!=null) {
							Element refBusLineMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:metadata", "oliot:Fiware");
							refBusLineMetadat.setTextContent(busEstimation.getRefBusLine().getValue().toString());
							
							refBusLine.appendChild(refBusLineMetadat);
						}
						
						elementList.add(refBusLine);
					}
					
					if(busEstimation.getRefBusStop()!=null) {
						Element refBusStop = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop", "oliot:Fiware");
						
						if(busEstimation.getRefBusStop().getType()!=null) {
							Element refBusStopType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:type", "oliot:Fiware");
							refBusStopType.setTextContent(busEstimation.getRefBusStop().getType());
							
							refBusStop.appendChild(refBusStopType);
						}
						if(busEstimation.getRefBusStop().getValue()!=null) {
							Element refBusStopValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:value", "oliot:Fiware");
							refBusStopValue.setTextContent(busEstimation.getRefBusStop().getValue().toString());
							
							refBusStop.appendChild(refBusStopValue);
						}
						if(busEstimation.getRefBusStop().getMetadat()!=null) {
							Element refBusStopMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:metadata", "oliot:Fiware");
							refBusStopMetadat.setTextContent(busEstimation.getRefBusStop().getValue().toString());
							
							refBusStop.appendChild(refBusStopMetadat);
						}
						
						elementList.add(refBusStop);
					}
					
					if(busEstimation.getRemainingDistances()!=null) {
						Element remainingDistances = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID", "oliot:Fiware");
						
						if(busEstimation.getRemainingDistances().getType()!=null) {
							Element remainingDistancesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:type", "oliot:Fiware");
							remainingDistancesType.setTextContent(busEstimation.getShortID().getType());
							
							remainingDistances.appendChild(remainingDistancesType);
						}
						if(busEstimation.getRemainingDistances().getValue()!=null) {
							Element remainingDistancesDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:value", "oliot:Fiware");
							String listRemainingDist="[";
							for(int i=0; i<busEstimation.getRemainingDistances().getValue().size(); i++) 
								listRemainingDist+=busEstimation.getRemainingDistances().getValue().get(i)+",";
							
							listRemainingDist=listRemainingDist.substring(0,listRemainingDist.length()-1)+"]";
							remainingDistancesDValue.setTextContent(listRemainingDist);
							
							remainingDistances.appendChild(remainingDistancesDValue);
						}
						if(busEstimation.getRemainingDistances().getMetadat()!=null) {
							Element remainingDistancesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:metadata", "oliot:Fiware");
							remainingDistancesMetadat.setTextContent(busEstimation.getShortID().getValue().toString());
							
							remainingDistances.appendChild(remainingDistancesMetadat);
						}
						
						elementList.add(remainingDistances);
					}
					
					if(busEstimation.getRemainingStations()!=null) {
						Element remainingStations = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations", "oliot:Fiware");
						
						if(busEstimation.getRemainingStations().getType()!=null) {
							Element remainingStationsType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:type", "oliot:Fiware");
							remainingStationsType.setTextContent(busEstimation.getRemainingStations().getType());
							
							remainingStations.appendChild(remainingStationsType);
						}
						if(busEstimation.getRemainingStations().getValue()!=null) {
							Element remainingStationsValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:value", "oliot:Fiware");
							remainingStationsValue.setTextContent(busEstimation.getRemainingStations().getValue().toString());
							
							remainingStations.appendChild(remainingStationsValue);
						}
						if(busEstimation.getRemainingStations().getMetadat()!=null) {
							Element remainingStationsMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:metadata", "oliot:Fiware");
							remainingStationsMetadat.setTextContent(busEstimation.getRemainingStations().getValue().toString());
							
							remainingStations.appendChild(remainingStationsMetadat);
						}
						
						elementList.add(remainingStations);
					}
					
					if(busEstimation.getRemainingTimes()!=null) {
						Element remainingTimes = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes", "oliot:Fiware");
						
						if(busEstimation.getRemainingTimes().getType()!=null) {
							Element remainingTimesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:type", "oliot:Fiware");
							remainingTimesType.setTextContent(busEstimation.getRemainingTimes().getType());
							
							remainingTimes.appendChild(remainingTimesType);
						}
						if(busEstimation.getRemainingTimes().getValue()!=null) {
							Element remainingTimesValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:value", "oliot:Fiware");
							remainingTimesValue.setTextContent(busEstimation.getRemainingTimes().getValue().toString());
							
							remainingTimes.appendChild(remainingTimesValue);
						}
						if(busEstimation.getRemainingTimes().getMetadat()!=null) {
							Element remainingTimesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:metadata", "oliot:Fiware");
							remainingTimesMetadat.setTextContent(busEstimation.getRemainingTimes().getValue().toString());
							
							remainingTimes.appendChild(remainingTimesMetadat);
						}
						
						elementList.add(remainingTimes);
					}
					
					if(busEstimation.getShortID()!=null) {
						Element shortID = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID", "oliot:Fiware");
						
						if(busEstimation.getShortID().getType()!=null) {
							Element shortIDType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:type", "oliot:Fiware");
							shortIDType.setTextContent(busEstimation.getShortID().getType());
							
							shortID.appendChild(shortIDType);
						}
						if(busEstimation.getShortID().getValue()!=null) {
							Element shortIDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:value", "oliot:Fiware");
							shortIDValue.setTextContent(busEstimation.getShortID().getValue().toString());
							
							shortID.appendChild(shortIDValue);
						}
						if(busEstimation.getShortID().getMetadat()!=null) {
							Element shortIDMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:metadata", "oliot:Fiware");
							shortIDMetadat.setTextContent(busEstimation.getShortID().getValue().toString());
							
							shortID.appendChild(shortIDMetadat);
						}
						
						elementList.add(shortID);
					}
					
					if(busEstimation.getGeolocation()!=null) {
						Element geolocation = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:", "oliot:Fiware");
						
						if(busEstimation.getGeolocation().getType()!=null) {
							Element geolocationType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:type", "oliot:Fiware");
							geolocationType.setTextContent(busEstimation.getGeolocation().getType());
							
							geolocation.appendChild(geolocationType);
						}
						if(busEstimation.getGeolocation().getValue()!=null) {
							Element geolocationValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value", "oliot:Fiware");
							if(busEstimation.getGeolocation().getValue().getType()!=null) {
								Element geolocationValueType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value:type", "oliot:Fiware");
								geolocationValueType.setTextContent(busEstimation.getGeolocation().getValue().getType());
								geolocationValue.appendChild(geolocationValueType);
							}
							
							if(busEstimation.getGeolocation().getValue().getCoordinates()!=null) {
								Element geolocationValueCoordinate = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value:coordinate", "oliot:Fiware");
								String coordinates="[";
								for(int i=0; i< busEstimation.getGeolocation().getValue().getCoordinates().size(); i++)coordinates+=busEstimation.getGeolocation().getValue().getCoordinates().get(i) +",";
								coordinates=coordinates.substring(0,coordinates.length()-1);
								coordinates+="]";
								geolocationValueCoordinate.setTextContent(coordinates);
								geolocationValue.appendChild(geolocationValueCoordinate);
							}
							
							
							
							geolocation.appendChild(geolocationValue);
						}
						if(busEstimation.getGeolocation().getMetadat()!=null) {
							Element geolocationMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:metadata", "oliot:Fiware");
							geolocationMetadat.setTextContent(busEstimation.getGeolocation().getMetadat().toString());
							
							geolocation.appendChild(geolocationMetadat);
						}
						
						elementList.add(geolocation);
					}
					
					
					
					

				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				objectEventType.setAnies(elementList);
				
				
		return objectEventType;
	}

	public static ObjectEventType translate(Alert alert) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Building building) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(BuildingOperation buildingOperation) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Open311ServiceRequest open311ServiceRequest) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Open311ServiceType open311ServiceType) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Device device) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(DeviceModel deviceModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(AeroAllergenObserved aeroAllergenObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(AirQualityObserved airQualityObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(NoiseLevelObserved noiseLevelObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(WaterQualityObserved WaterQualityObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(KeyPerformanceIndicator keyPerformanceIndicator) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(OffStreetParking offStreetParking) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(OnStreetParking onStreetParking) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingAccess parkingAccess) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingGroup parkingGroup) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingSpot parkingSpot) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(FlowerBed flowerBed) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Garden garden) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(GreenspaceRecord greenspaceRecord) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Park park) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Beach beach) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Museum museum) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(PointOfInterest pointOfInterest) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(TouristInformationCenter touristInformationCenter) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Streetlight streetlight) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightControlCabinet streetlightControlCabinet) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightGroup streetlightGroup) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightModel streetlightModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(Road road) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(TrafficFlowObserved trafficFlowObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(Vehicle vehicle) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(VehicleModel vehicleModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainer WasteContainer) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainerIsle wasteContainerIsle) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainerModel wasteContainerModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherAlarm weatherAlarm) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherForecast weatherForecast) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherObserved weatherObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	

}
