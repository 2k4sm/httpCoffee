package dto

import (
	"github.com/2k4sm/httpCoffee/src/main/entities"
)

type User struct {
	Id       uint      `json:"id"`
	Name     string    `json:"user_name"`
	Email    string    `json:"email"`
	Password string    `json:"password"`
	Orders   []Payment `json:"orders"`
}

type CreateUser struct {
	Name     string `json:"user_name"`
	Email    string `json:"email"`
	Password string `json:"password"`
}

func ParseToUserEntity(createUser CreateUser) entities.User {

	user := entities.User{
		Name:     createUser.Name,
		Email:    createUser.Email,
		Password: createUser.Password,
	}

	return user
}

func ParseFromUserEntity(user entities.User) User {

	payments := []Payment{}
	for _, payment := range user.Orders {
		payments = append(payments, ParseFromPaymentEntity(payment))
	}

	return User{
		Id:       user.ID,
		Name:     user.Name,
		Email:    user.Email,
		Password: user.Password,
		Orders:   payments,
	}
}
