# -*- coding: utf-8 -*-
# Generated by Django 1.10.2 on 2016-11-07 04:59
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ngo', '0005_auto_20161105_0419'),
    ]

    operations = [
        migrations.AddField(
            model_name='ngo',
            name='mail',
            field=models.EmailField(blank=True, default=None, max_length=254, null=True),
        ),
    ]