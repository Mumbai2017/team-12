# -*- coding: utf-8 -*-
# Generated by Django 1.10.5 on 2017-07-29 14:42
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('MakeAWish', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='volunteer',
            name='contact_no',
            field=models.BigIntegerField(default=9870486233),
        ),
        migrations.AddField(
            model_name='volunteer',
            name='email',
            field=models.EmailField(default='suhailsbarot@gmail.com', max_length=254),
        ),
    ]