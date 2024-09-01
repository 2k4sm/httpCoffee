package entities

import "gorm.io/gorm"

type CoffeeHouse struct {
	gorm.Model
	Name             string   `gorm:"not null unique"`
	UserCount        int64    `gorm:"not null default:0 index"`
	Revenue          int64    `gorm:"not null default:0 index"`
	AvailableCoffees []Coffee `gorm:"many2many:coffee_house_coffees"`
}
