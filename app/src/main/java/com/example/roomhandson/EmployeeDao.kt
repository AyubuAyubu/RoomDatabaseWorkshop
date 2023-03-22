package com.example.roomhandson

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
	@Insert
	suspend fun insert(employeeEntity: EmployeeEntity)

	@Update
	suspend fun update(employeeEntity: EmployeeEntity)

	@Delete
	suspend fun delete(employeeEntity: EmployeeEntity)

	//Flow holds value that can always change on life time
	//Collect value from method without repeating the code or
	//notify recycler view on those changes
	@Query("Select * from `employee-table`")
	fun fetchAllEmployee(): Flow<List<EmployeeEntity>>

	@Query("Select * from `employee-table` where id=:id")
	fun fetchEmployeeById(id:Int):Flow<EmployeeEntity>
}