import { FarmHouseDto } from "./farmhouse";
import { UserDto } from "./user";

export class TaskDto{
    taskId?: string;
    userDto?: UserDto;
    userId?: string;
    farmHouseDto?:FarmHouseDto;
    farmhouseId?:string;
    farmHouseName?:string;
    taskTitle?:string;
    taskType?:string;
    startDate?:string;
    endDate?:string;
    remarks?:string;
}